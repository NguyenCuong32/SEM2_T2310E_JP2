package com.example.javafx30072024.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
    private static ConnectJDBC instance;
    private Connection connection;

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://150.95.110.169:3306/test";
    static final String USER = "adsasdcxcz";
    static final String PASS = "adsasdcxcz";


    private ConnectJDBC() {
        try {
            this.connection = DriverManager.getConnection(DB_URL, USER, PASS);
            if (this.connection != null && !this.connection.isClosed()) {
                System.out.println("Connected");
            } else {
                System.out.println("Not Connected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ConnectJDBC getInstance() {
        if (instance == null) {
            synchronized (ConnectJDBC.class) {
                if (instance == null) {
                    instance = new ConnectJDBC();
                }
            }
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
