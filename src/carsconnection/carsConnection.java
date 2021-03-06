package carsconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class carsConnection {

    //connect to the cars database
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                   "jdbc:mysql://127.0.0.1:3306/Cars", "root", ""); //database source , database username , database password
            //check if database is connected
            if (conn != null) { 
                System.out.println("Connected to the database!");
                System.out.println("");
            } else {
                System.out.println("Failed to make connection!");
                System.out.println("");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
}
