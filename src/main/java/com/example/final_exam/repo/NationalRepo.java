package com.example.final_exam.repo;

import com.example.final_exam.model.NationalModel;
import com.example.final_exam.util.JDBCConnector;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NationalRepo implements IRepo<NationalModel, Integer> {
    @Override
    public List<NationalModel> findAll() {
        String sql = "SELECT * FROM herogame.national";

        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            List<NationalModel> modelList = new ArrayList<>();
            CallableStatement callStmt = conn.prepareCall(sql);
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                NationalModel model = new NationalModel();
                model.setNationalId(rs.getInt("NationalId"));
                model.setNationalName("NationalName");
                modelList.add(model);
            }
            return modelList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NationalModel findByName(String name) {
        return null;
    }

    @Override
    public void save(NationalModel data) {
        String sql = "INSERT INTO herogame.national(NationalName) VALUE (?)";
        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            if (conn != null && !conn.isClosed()) {
                CallableStatement statement = conn.prepareCall(sql);
                statement.setString(1, data.getNationalName());
                statement.execute();
            }
        } catch (Exception e) {
            System.out.println("Something wrong with the connection");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM herogame.national WHERE NationalId = ?";
        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            if (conn != null && !conn.isClosed()) {
                CallableStatement statement = conn.prepareCall(sql);
                statement.setInt(1, id);
                statement.execute();
            }
        } catch (Exception e) {
            System.out.println("Something wrong with the connection");
        }
    }

    @Override
    public void update(NationalModel data) {

    }
}
