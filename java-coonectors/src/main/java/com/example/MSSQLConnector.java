package com.example;

import java.sql.*;

public class MSSQLConnector {

    public static void main(String[] args) {
        //52005 is HAProxy port. The code does not set any proxy settings
        String jdbcUrl = "jdbc:sqlserver://localhost:52005;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "StrongPassword123";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to MSSQL server via HAProxy successfully.");
            connection.getClientInfo();
        } catch (SQLException e) {
            System.err.println("Error connecting to MSSQL server: " + e.getMessage());
        }
    }
}
