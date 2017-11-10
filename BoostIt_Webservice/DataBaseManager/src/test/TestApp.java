package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DBManager;

public class TestApp {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getConnection();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select u.* from users u");
        } catch (SQLException e) {
            System.err.println("Test: Error at stmt or rs: " + e.getMessage());
        }

        if (rs != null) {
            System.out.println("Test: rs != null");
            try {
                while (rs.next()) {
                    System.out.println("Test: IT WORKS");
                }
            } catch (SQLException e) {
                System.err.println("Test: Error at rs.next(): " + e.getMessage());
            }
        } else {
            System.out.println("Test: rs = null");
        }

        DBManager.close(rs);
        DBManager.close(stmt);
        DBManager.close(con);
    }

}
