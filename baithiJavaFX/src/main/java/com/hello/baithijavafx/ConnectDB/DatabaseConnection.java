package com.hello.baithijavafx.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String local = "localhost";
    private Integer port = 3306;
    private String databaseName = "herogame";
    private String username = "root";
    private String password = "";
    private String host = local + ":" + port;
    private String url = "jdbc:mysql://" + host + "/" + databaseName;
    private static DatabaseConnection instance;
    private static Connection conn;

    private DatabaseConnection() {
        try {
            System.out.println("URL: " + url);
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static Connection getConnection() {
        return conn;
    }
}
