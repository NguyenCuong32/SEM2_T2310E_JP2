package com.example.javafx30072024.service.RepositoryDetailImpl;

import com.example.javafx30072024.service.ConnectJDBC;
import com.example.javafx30072024.service.NationalRepository;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class NationalRepositoryImpl implements NationalRepository {
    @Override
    public void save(String name) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call InsertNational1(?,?,?,?)}");
            callStmt.setString("p_nationalName", name);
            callStmt.executeQuery();
            callStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long nationalId) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DeleteNationalById(?)}");
            callStmt.setLong("p_nationalId", nationalId);
            callStmt.execute();
            callStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
