package com.example.repository;

import java.sql.CallableStatement;
import java.util.List;

import com.example.entity.Player;

public class PlayerRepository implements IPalyerRepository {

    @Override
    public void save(Player player) {
        try {
            var conn = ConnectJDBC.getConnectJDBC().getConnection();
            if(conn != null && !conn.isClosed()) {
                CallableStatement callStmt = conn.prepareCall("{ call INSERT_PLAYER(?, ?, ?, ?, ?)}");
                callStmt.setInt("PlayerId", player.getPlayerID());
                callStmt.setInt("NationalId", player.getNationalID());
                callStmt.setString("PlayerName", player.getPlayerName());
                callStmt.setInt("HighScore", player.getHighScore());
                callStmt.setInt("Level", player.getLevel());
                callStmt.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer playerId) {
        try {
            var conn = ConnectJDBC.getConnectJDBC().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DELETE_PLAYER(?)}");
            if (conn != null && !conn.isClosed()) {
                callStmt.setInt("PlayerId", playerId);
                callStmt.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player findById(Integer playerId) {
        try {
            var conn = ConnectJDBC.getConnectJDBC().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call FIND_BY_ID(?)}");
            if(conn != null && !conn.isClosed()) {
                callStmt.setInt("PlayerId", playerId);
                callStmt.execute();
            }
            var resultSet = callStmt.executeQuery();
            if(resultSet.next()) {
                Integer playerID = resultSet.getInt("PlayerId");
                Integer nationalID = resultSet.getInt("NationalId");
                String playerName = resultSet.getString("PlayerName");
                Integer hightScore = resultSet.getInt("HighScore");
                Integer level = resultSet.getInt("Level");
                Player player = new Player(playerID, nationalID, playerName, hightScore, level);
                return player;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Player> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
