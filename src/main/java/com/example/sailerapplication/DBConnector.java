package com.example.sailerapplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * THIS CLASS CONTAINS THE DATABASE CONNECTOR that permits the connection to the database by authenticating in it trough DB credentials
 *  @author      Montasser Ben Rejeb <montasser.benrejeb@studenti.unipr.it>
 *  @author      wajdi.lajdal <wajdi.lajdal@studenti.unipr.it>
 *
 */

public class DBConnector {

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/sailclub_db", "root", "");
        return connection;
    }


}
