/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import connection.DBManager;
import data.Phrase;
import data.PhraseBelongs;
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
@Path("PhraseDetail")
public class PhraseDetail {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public PhraseDetail() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{phrase_id}")
    public Phrase getPhrase(@PathParam("phrase_id") String phrase_id) {
        Phrase retPhrase = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from phrases where phrase_id = " + phrase_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retPhrase = new Phrase(Integer.parseInt(rs.getObject(1).toString()),
                            rs.getObject(2).toString(), rs.getObject(3).toString(),
                            new WordDetail().getWord(rs.getObject(4).toString()));
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addPhrase(Phrase phrase) {
        String retValue = "inserted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("insert into phrases values (seq_phrases.nextval, '"
                    + phrase.gettGerman() + "', '" + phrase.gettEnglish() + "', "
                    + phrase.getWord().getWord_id() + ")");
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
    public String updatePhrase(Phrase phrase) {
        String retValue = "updated";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("update phrases set tGerman = '" + phrase.gettGerman()
                    + "', tEnglish = '" + phrase.gettEnglish()
                    + "', word_id = " + phrase.getWord().getWord_id() 
                    + " where phrase_id = " + phrase.getPhrase_id());

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
    public String deletePhrase(@QueryParam("phrase_id") String phrase_id) {
        String retValue = "deleted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("delete from phrases where phrase_id = " + phrase_id);
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{phrase_id}/Unit/{unit_id}")
    public PhraseBelongs getUnitFromPhrase(@PathParam("phrase_id") String phrase_id, @PathParam("unit_id") String unit_id) {
        PhraseBelongs retUnit = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from phrasebelongs where phrase_id = " + phrase_id 
                    + " and unit_id = " + unit_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retUnit = new PhraseBelongs(new PhraseDetail().getPhrase(rs.getObject(1).toString()),
                            new UnitDetail().getUnit(rs.getObject(2).toString()));
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retUnit;
    }
}
