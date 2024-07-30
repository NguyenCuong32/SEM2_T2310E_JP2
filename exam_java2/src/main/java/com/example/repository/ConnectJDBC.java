package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String local = "localhost";
    private Integer port = 3306;
    private String databaseName = "finaltestjava2";
    private String userName = "root";
    private String password = "";
    private String host = local+":"+port;
    private String url = "jdbc:mysql://"+host+"/"+databaseName;

    private static ConnectJDBC connectJDBC;
    public static ConnectJDBC getConnectJDBC(){
        if(connectJDBC == null) {
            synchronized (ConnectJDBC.class) {
                connectJDBC = new ConnectJDBC();
                return connectJDBC;
            }
        }
        return connectJDBC;
    }

    private Connection conn;
    public ConnectJDBC(){
        try {
            this.conn = DriverManager.getConnection(url, userName, password);
            if(conn != null && !conn.isClosed()) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Faied to conected to database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection() {
        return this.conn;
    }
}
