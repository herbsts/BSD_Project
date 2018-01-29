/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.DBManager;
import data.Unit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
@Path("UnitDetail")
public class UnitDetail {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public UnitDetail() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{unit_id}")
    public Unit getUnit(@PathParam("unit_id") String unit_id) {
        Unit retUnit = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from units where unit_id = " + unit_id);
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                if (rs.next()) {
                    retUnit = new Unit(Integer.parseInt(rs.getObject(1).toString()), 
                            rs.getObject(2).toString(), 
                            new UserDetail().getUser(rs.getObject(3).toString()));
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

    @POST
    @Consumes({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
    public String addUnit(Unit unit) throws Exception {
        String retValue = "inserted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate("insert into units values (" + unit.getUnit_id() 
                    + ", '" + unit.getDescripiton() + "', '" + unit.getCreator().getUser_id() + ")");
            stmt.execute("commit");
        } catch (NumberFormatException e) {
            System.err.println("unit_id is not a number");
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
    public String updateUnit(Unit unit) throws IOException {
        String retValue = "updated";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("update units set description = '" + unit.getDescripiton()
                    + " where unit_id = " + unit.getUnit_id());

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
    public String deleteUnit(@QueryParam("unit_id") String unit_id) throws IOException {
        String retValue = "deleted";

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.executeUpdate("delete from units where id = " + unit_id);
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
