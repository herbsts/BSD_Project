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
@Path("RequestDetail")
public class RequestDetail {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public RequestDetail() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{request_id}")
    public Request getRequest(@PathParam("request_id") String request_id) {
        Request retRequest = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from requests where req_id = " + request_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retRequest = new Request(rs.getInt(1), rs.getDate("req_date"),
                            rs.getDate("edit_date"), rs.getString(4), 
                            new UserDetail().getUser(rs.getString(5)));
                }
            } catch (SQLException e) {
                System.err.println("Error at rs.next(): " + e.getMessage());
            }
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
        System.out.println("==============webservice BoostIt GET called");

        return retRequest;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addRequest(Request request) {
        String retValue = "inserted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("insert into requests values (seq_requests.nextval, "
                    + request.getRequestDate()+ ", " + request.getEditDate() + ", '" 
                    + request.getStatus() + "', " + request.getUser().getUser_id() + ")");
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
    public String updateRequest(Request request) {
        String retValue = "updated";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("update requests set req_date = " + request.getRequestDate() 
                    + ", edit_date = " + request.getEditDate() + ", status = '" + request.getStatus() 
                    + "', user_id = " + request.getUser().getUser_id()
                    + " where req_id = " + request.getRequest_id());

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
    public String deleteRequest(@QueryParam("request_id") String request_id) {
        String retValue = "deleted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("delete from requests where req_id = " + request_id);
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
}
