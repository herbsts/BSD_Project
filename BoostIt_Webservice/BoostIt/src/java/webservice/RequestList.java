/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import connection.DBManager;
import data.Request;
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
@Path("RequestList")
public class RequestList {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public RequestList() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user_id}")
    public ArrayList<Request> getRequests(@PathParam("user_id") String user_id) {
        Request p = null;
        ArrayList<Request> retList = new ArrayList();

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from requests where user_id = " + user_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    p = new Request(rs.getInt(1), rs.getDate("req_date"),
                            rs.getDate("edit_date"), rs.getString(4), new UserDetail().getUser(user_id));
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
