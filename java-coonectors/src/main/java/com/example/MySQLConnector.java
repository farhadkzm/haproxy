package com.example;

import java.sql.*;

public class MySQLConnector {

    public static void main(String[] args) {
        //52001 is HAProxy port. The code does not set any proxy settings
        String jdbcUrl = "jdbc:mysql://localhost:52001/db";
        String username = "user";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to MySQL server via HAProxy successfully.");

            connection.getClientInfo();
        } catch (SQLException e) {
            System.err.println("Error connecting to MySQL server: " + e.getMessage());
        }
    }
}
