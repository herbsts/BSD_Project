/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import connection.DBManager;
import data.Phrase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author schueler
 */
@Path("PhraseList")
public class PhraseList {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public PhraseList() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{english_word}")
    public ArrayList<Phrase> getPhrases(@PathParam("english_word") String english_word) {
        Phrase p = null;
        ArrayList<Phrase> retList = new ArrayList();

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from phrases where word_id = " + english_word);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    p = new Phrase(Integer.parseInt(rs.getObject(1).toString()), 
                            rs.getObject(2).toString(), 
                            rs.getObject(3).toString(), 
                            new WordEnglish().getGermanWord(english_word));
                    retList.add(p);
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retList;
    }
}
