/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.DBManager;
import data.Unit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author schueler
 */
@Path("UnitList")
public class UnitList {

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public UnitList() {
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ArrayList<Unit> getUnits() {
        Unit u = null;
        ArrayList<Unit> retList = new ArrayList();

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from units");
        } catch (SQLException e) {
            System.err.println("Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            try {
                while (rs.next()) {
                    u = new Unit(Integer.parseInt(rs.getObject(1).toString()), 
                            rs.getObject(2).toString(), 
                            new UserDetail().getUser(rs.getObject(3).toString()));
                    retList.add(u);
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
