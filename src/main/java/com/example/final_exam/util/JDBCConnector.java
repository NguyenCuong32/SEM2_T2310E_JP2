package com.example.final_exam.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnector {
    private String url = "jdbc:mysql://localhost";
    private Integer port = 3306;
    private String databaseName = "HeroGame";
    private String username = "root";
    private String password = "admin";
    private String host = url + ":" + port + "/" + databaseName;
    private Connection connection = null;
    private static JDBCConnector instance = null;

    private JDBCConnector() {}

    public Connection getConnection() {
        return this.connection;
    }

    private void init() {
        try {
            connection = DriverManager.getConnection(host, username, password);
            System.out.println("init and connect success");
        } catch (Exception e) {
            System.out.println("connect failed!");
        }
    }

    public static JDBCConnector getInstance() {
        try {
            if (instance != null && !instance.getConnection().isClosed()) {
                System.out.println("Already have connection! connect success");
                return instance;
            } else {
                instance = new JDBCConnector();
                instance.init();
            }
        } catch (Exception e) {
            System.out.println();
        }
        return instance;
    }

}
