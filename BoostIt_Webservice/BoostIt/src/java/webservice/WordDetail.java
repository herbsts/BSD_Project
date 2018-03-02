/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import connection.DBManager;
import data.Word;
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
@Path("WordDetail")
public class WordDetail {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public WordDetail() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{word_id}")
    public Word getWord(@PathParam("word_id") String word_id) {
        Word retWord = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from words where word_id = " + word_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retWord = new Word(Integer.parseInt(rs.getObject(1).toString()),
                            rs.getObject(2).toString(), rs.getObject(3).toString(),
                            rs.getString(4), rs.getString(5), rs.getString(6));
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addWord(Word word) {
        String retValue = "inserted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("insert into words values (seq_words.nextval, '"
                    + word.gettGerman() + "', '" + word.gettEnglish() + "', '" 
                    + word.getVarietyOfEnglish() + "', '" + word.getPartOfSpeech() 
                    + "', '" + word.getUsage() + "')");
            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("SQL-Error at stmt: " + e.getMessage());
            retValue = "SQL-Error at stmt: " + e.getMessage();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            retValue = "Error: " + e.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);

        System.out.println("==============webservice BoostIt POST called");

        return retValue;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateWord(Word word) {
        String retValue = "updated";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("update words set tGerman = '" + word.gettGerman()
                    + "', tEnglish = '" + word.gettEnglish()
                    + "', variety = '" + word.getVarietyOfEnglish()
                    + "', pos = '" + word.getPartOfSpeech()
                    + "', usage = '" + word.getUsage()
                    + "' where word_id = " + word.getWord_id());

            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("SQL-Error at stmt: " + e.getMessage());
            retValue = "SQL-Error at stmt: " + e.getMessage();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            retValue = "Error: " + e.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);

        System.out.println("==============webservice BoostIt PUT called");

        return retValue;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteWord(@QueryParam("word_id") String word_id) {
        String retValue = "deleted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("delete from words where word_id = " + word_id);
            stmt.execute("commit");
        } catch (SQLException e) {
            System.err.println("SQL-Error at stmt: " + e.getMessage());
            retValue = "SQL-Error at stmt: " + e.getMessage();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            retValue = "Error: " + e.getMessage();
        }

        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt DELETE called");

        return retValue;
    }
    
    public Word getWordByTEnglish(String tEnglish) {
        Word retWord = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from words where tEnglish = " + tEnglish);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retWord = new Word(Integer.parseInt(rs.getObject(1).toString()),
                            rs.getObject(2).toString(), rs.getObject(3).toString(),
                            rs.getString(4), rs.getString(5), rs.getString(6));
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
}
