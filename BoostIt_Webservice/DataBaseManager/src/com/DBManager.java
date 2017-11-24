package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBManager {

    private static String urlIntern = "jdbc:oracle:thin:@192.168.128.152:1521:ora11g";
    private static String urlExtern = "jdbc:oracle:thin:@212.152.179.117:1521:ora11g";
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String user = "d5b12";
    private static String pwd = "d5b";

    private static boolean instanceExists = false;

    // Singleton Pattern
    private static DBManager dbm = new DBManager();

    private DBManager() {
        if (instanceExists) {
            try {
                throw new Exception("Only one Singleton");
            } catch (Exception e) {
                System.err.println("Singleton ERROR: " + e.getMessage());
            }
        } else {
            instanceExists = true;
            try {
                Class.forName(driver);
                System.out.println("Log: Driver loaded successfully");
                DriverManager.setLoginTimeout(60);
            } catch (Exception e) {
                System.err.println("Driver ERROR: " + e.getMessage());
            }
        }
    }

    public static Connection getConnection() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(urlIntern, user, pwd);
        } catch (Exception e_intern) {
            try {
                con = DriverManager.getConnection(urlExtern, user, pwd);
            } catch (Exception e_extern) {
                System.err.println("Error: Could not connect to Database with extern URL: " + e_extern.getMessage());
            }
            System.err.println("Error: Could not connect to Database with intern URL: " + e_intern.getMessage());
        }
        System.out.println("Log: Connected successfully");

        return con;
    }

    public static boolean close(Connection con) {
        boolean retValue;

        try {
            con.close();
            System.out.println("Log: Disonnected successfully");
            retValue = true;
        } catch (Exception ignored) {
            retValue = false;
        }

        return retValue;
    }

    public static boolean close(ResultSet rs) {
        boolean retValue;
        try {
            rs.close();
            retValue = true;
        } catch (Exception ignored) {
            retValue = false;
        }
        return retValue;
    }

    public static boolean close(Statement stmt) {
        boolean retValue;
        try {
            stmt.close();
            retValue = true;
        } catch (Exception ignored) {
            retValue = false;
        }
        return retValue;
    }

    public void finalize() {
        instanceExists = false;
    }
}
