package com.example.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
    private static ConnectJDBC instance;
    private Connection connection;
    private String host = "localhost:3306";
    private String db = "herogame";
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://" + host + "/" + db;

    private ConnectJDBC() {
        try {
            this.connection = DriverManager.getConnection(url, user, pass);
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