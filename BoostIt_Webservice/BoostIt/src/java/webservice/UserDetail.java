/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import connection.DBManager;
import data.User;
import data.UserBelongsTo;
import data.UserOwnsPhrase;
import data.UserOwnsWord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author schueler
 */
@Path("UserDetail")
public class UserDetail {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public UserDetail() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user_id}")
    public User getUser(@PathParam("user_id") String user_id) {
        User retUser = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from users where user_id = " + user_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retUser = new User(Integer.parseInt(rs.getObject(1).toString()),
                            rs.getObject(2).toString(), rs.getObject(3).toString(),
                            Integer.parseInt(rs.getObject(4).toString()));
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retUser;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(User user) {
        String retValue = "inserted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("insert into users values (seq_userid.nextval, '"
                    + user.getUsername() + "', '" + user.getPassword() + "', "
                    + user.getRole() + ")");
            stmt.execute("commit");
        } catch (NumberFormatException e) {
            System.err.println("role is not a number: " + e.getMessage());
            retValue = "role is not a number: " + e.getMessage();
        } catch (SQLException e) {
            System.err.println("SQL-Error at stmt: " + e.getMessage());
            retValue = "SQL-Error at stmt: " + e.getMessage();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            retValue = "Error: " + ex.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);

        System.out.println("==============webservice BoostIt POST called");

        return retValue;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateUser(User user) {
        String retValue = "updated";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("update users set username = '" + user.getUsername()
                    + "', password = '" + user.getPassword()
                    + "', role = " + user.getRole() + " where user_id = " + user.getUser_id());

            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("SQL-Error at stmt: " + e.getMessage());
            retValue = "SQL-Error at stmt: " + e.getMessage();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            retValue = "Error: " + ex.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);

        System.out.println("==============webservice BoostIt PUT called");

        return retValue;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteUser(@QueryParam("user_id") String user_id) {
        String retValue = "deleted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("delete from users where user_id = " + user_id);
            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("SQL-Error at stmt: " + e.getMessage());
            retValue = "SQL-Error at stmt: " + e.getMessage();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            retValue = "Error: " + ex.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt DELETE called");

        return retValue;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user_id}/Word/{word_id}")
    public UserOwnsWord getWordFromUser(@PathParam("user_id") String user_id, @PathParam("word_id") String word_id) {
        UserOwnsWord retWord = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from ownsword where user_id = " + user_id 
                    + " and word_id = " + word_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retWord = new UserOwnsWord(rs.getInt("id"), 
                            new UserDetail().getUser(rs.getObject("user_id").toString()), 
                            new WordDetail().getWord(rs.getObject("word_id").toString()), 
                            rs.getDate("lastRevised"), rs.getFloat("accuracy"));
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retWord;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user_id}/Phrase/{phrase_id}")
    public UserOwnsPhrase getPhraseFromUser(@PathParam("user_id") String user_id, @PathParam("phrase_id") String phrase_id) {
        UserOwnsPhrase retPhrase = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from ownsphrase where phrase_id = " + phrase_id 
                    + " and user_id = " + user_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {                    
                    retPhrase = new UserOwnsPhrase(rs.getInt(1), 
                            new PhraseDetail().getPhrase(rs.getObject(2).toString()),
                            new UserDetail().getUser(rs.getObject(3).toString()), 
                            rs.getDate(4), 
                            rs.getFloat(5));
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retPhrase;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user_id}/Teacher/{teacher_id}")
    public UserBelongsTo getClassFromUser(@PathParam("user_id") String user_id, @PathParam("teacher_id") String teacher_id) {
        UserBelongsTo retClass = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from belongsto where user_id = " + user_id 
                    + " and teacher_id = " + teacher_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retClass = new UserBelongsTo(
                            new UserDetail().getUser(rs.getObject("user_id").toString()), 
                            new UserDetail().getUser(rs.getObject("user_id").toString()), 
                            rs.getString("class"));
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retClass;
    }
}
