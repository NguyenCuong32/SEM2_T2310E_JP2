package com.example.repository;

import java.sql.CallableStatement;
import java.util.List;

import com.example.entity.National;

public class NationalRepository implements INationalRepository {

    @Override
    public void save(National national) {
        try {
            var conn = ConnectJDBC.getConnectJDBC().getConnection();
            if(conn != null && !conn.isClosed()) {
                CallableStatement callStmt = conn.prepareCall("{ call INSERT_NATIONAL(?, ?)}");
                callStmt.setInt("NationalId", national.getNationalID());
                callStmt.setString("NationalName", national.getNationalName());
                callStmt.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer nationalId) {
        try {
            var conn = ConnectJDBC.getConnectJDBC().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DELETE_NATIONAL(?)}");
            if (conn != null && !conn.isClosed()) {
                callStmt.setInt("NationalId", nationalId);
                callStmt.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public National findById(Integer nationalId) {
        try {
            var conn = ConnectJDBC.getConnectJDBC().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call FIND_BY_ID(?)}");
            if(conn != null && !conn.isClosed()) {
                callStmt.setInt("NationalId", nationalId);
                callStmt.execute();
            }
            var resultSet = callStmt.executeQuery();
            if(resultSet.next()) {
                Integer NationalID = resultSet.getInt("NationalId");
                String NationalName = resultSet.getString("NationalName");
                National national = new National(NationalID, NationalName);
                return national;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<National> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
