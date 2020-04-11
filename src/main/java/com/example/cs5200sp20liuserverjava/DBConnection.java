package com.example.cs5200sp20liuserverjava;

import java.sql.*;

public class DBConnection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://cs5200-spring20-liu.c5zzc69kbdze.us-east-2.rds.amazonaws.com/cs5200?serverTimezone=UTC";
    private static final String USER = "xinton";
    private static final String PASSWORD = "lxt=YUAN1";
    private static Connection dbConnection = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);

        if (dbConnection == null) {
            dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
            return dbConnection;
        } else { return dbConnection; } }

    public static void closeConnection() {
        try {
            if (dbConnection != null) {
                dbConnection.close();
                dbConnection = null; }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
