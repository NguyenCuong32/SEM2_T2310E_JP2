package com.example.finaltest.Reponsitory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String local = "localhost";
    private Integer port = 3306;
    private String databaseName = "finaltest";
    private String username = "root";
    private String password = "Quanghuy@0612";
    private String host = local + ":" + port;
    private String url = "jdbc:mysql://" + host + "/" + databaseName;

    private static ConnectJDBC instance;
    private Connection conn;

    private ConnectJDBC() {
        connect();
    }

    public static ConnectJDBC getInstance() {
        if (instance == null) {
            synchronized (ConnectJDBC.class) {
                if (instance == null) {
                    instance = new ConnectJDBC();
                    System.out.println("Connecting to database...");
                }
            }
        }
        return instance;
    }

    private void connect() {
        try {
            System.out.println("URL: " + url);
            this.conn = DriverManager.getConnection(url, username, password);
            if (conn != null && !conn.isClosed()) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}

