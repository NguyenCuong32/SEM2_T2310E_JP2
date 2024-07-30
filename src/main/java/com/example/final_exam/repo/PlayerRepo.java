package com.example.final_exam.repo;

import com.example.final_exam.model.PlayerModel;
import com.example.final_exam.util.JDBCConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepo implements IRepo<PlayerModel, Integer> {
    @Override
    public List<PlayerModel> findAll() {
        String sql = "SELECT * FROM herogame.player";

        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            List<PlayerModel> modelList = new ArrayList<>();
            CallableStatement callStmt = conn.prepareCall(sql);
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                PlayerModel model = new PlayerModel();
                model.setPlayerId(rs.getInt("PlayerId"));
                model.setNationalId(rs.getInt("NationalId"));
                model.setPlayerName(rs.getString("PlayerName"));
                model.setHighScore(rs.getInt("HighScore"));
                model.setLevel(rs.getInt("Level"));
                modelList.add(model);
            }
            return modelList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PlayerModel findByName(String name) {
        String sql = "SELECT * FROM herogame.player WHERE PlayerName = ?";
        PlayerModel result = null;

        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            PreparedStatement statement = conn.prepareCall(sql);
            if (conn != null && !conn.isClosed()) {
                statement.setString(1, name);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    result = new PlayerModel();
                    result.setPlayerId(resultSet.getInt("PlayerId"));
                    result.setNationalId(resultSet.getInt("NationalId"));
                    result.setPlayerName(resultSet.getString("PlayerName"));
                    result.setHighScore(resultSet.getInt("HighScore"));
                    result.setLevel(resultSet.getInt("Level"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error find by name: " + e.getMessage());
        }

        return result;
    }

    @Override
    public void save(PlayerModel data) {
        String sql = "INSERT INTO herogame.player(NationalId, PlayerName, HighScore, Level) VALUE (?,?,?,?)";
        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            if (conn != null && !conn.isClosed()) {
                CallableStatement statement = conn.prepareCall(sql);
                statement.setInt(1, data.getNationalId());
                statement.setString(2, data.getPlayerName());
                statement.setInt(3, data.getHighScore());
                statement.setInt(4, data.getLevel());
                statement.execute();
            }
        } catch (Exception e) {
            System.out.println("Something wrong with the connection");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM herogame.player WHERE PlayerId = ?";
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
    public void update(PlayerModel data) {
    }

    public List<PlayerModel> findTop10() {
        String sql = "SELECT * FROM herogame.player ORDER BY HighScore DESC LIMIT 10";

        try {
            Connection conn = JDBCConnector.getInstance().getConnection();
            List<PlayerModel> modelList = new ArrayList<>();
            CallableStatement callStmt = conn.prepareCall(sql);
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                PlayerModel model = new PlayerModel();
                model.setPlayerId(rs.getInt("PlayerId"));
                model.setNationalId(rs.getInt("NationalId"));
                model.setPlayerName(rs.getString("PlayerName"));
                model.setHighScore(rs.getInt("HighScore"));
                model.setLevel(rs.getInt("Level"));
                modelList.add(model);
            }
            return modelList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
