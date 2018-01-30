/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import connection.DBManager;
import data.User;
import java.io.IOException;
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
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    public String addUser(User user) throws Exception {
        String retValue = "inserted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("insert into users values (" + user.getUser_id() + ", '"
                    + user.getUsername() + "', '" + user.getPassword() + "', "
                    + user.getRole() + ")");
            stmt.execute("commit");
        } catch (NumberFormatException e) {
            System.err.println("user_id/role is not a number");
            retValue = e.getMessage();
        } catch (SQLException e) {
            System.err.println("Error at stmt: " + e.getMessage());
            retValue = e.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);

        System.out.println("==============webservice BoostIt POST called");

        return retValue;
    }

    @PUT
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    public String updateUser(User user) throws IOException {
        String retValue = "updated";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("update users set username = '" + user.getUsername()
                    + "', password = '" + user.getPassword()
                    + "', role = " + user.getRole() + " where user_id = " + user.getUser_id());

            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
            retValue = e.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);

        System.out.println("==============webservice BoostIt PUT called");

        return retValue;
    }

    @DELETE
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    public String deleteUser(@QueryParam("user_id") String user_id) throws IOException {
        String retValue = "deleted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("delete from users where user_id = " + user_id);
            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
            retValue = e.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt DELETE called");

        return retValue;
    }
}
