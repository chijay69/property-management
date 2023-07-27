package com.mycompany.propertymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLServerConnectionTest {

    public static void main(String[] args) {
        // JDBC connection parameters
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=pmdb";
        String username = "SqlBot";
        String password = "SqlBot";

        try {
            // Load the SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(dbUrl, username, password);

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connection to Microsoft SQL Server database successful!");
                connection.close();
            } else {
                System.out.println("Failed to establish the connection.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Server JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to Microsoft SQL Server failed!");
            e.printStackTrace();
        }
    }
}
