package com.example.repository;

import java.sql.CallableStatement;
import java.sql.Connection;

import com.example.entity.Player;

public class PlayerRepository implements IPlayerRepository {

    @Override
    public void savePlayerList(Player player) {
        try {
            Connection conn = ConnectJDBC.getConnectJDBC().getConnection();
            if(conn != null && !conn.isClosed()){
                System.out.println("connected to database");
                CallableStatement statement = conn.prepareCall("{call INSERT_PLAYER(?, ?, ?, ?, ?)}");
                statement.setString("PlayerName", player.getPlayerName());
                statement.setInt("HighScore", player.getHighScore());
                statement.setInt("Level", player.getLevel());
                statement.setInt("NationalId", player.getNationalId());
                statement.execute();
                statement.close();
                System.out.println("Inserted player");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> displayAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void findById(Integer PlayerID) {
        public Player findById(Integer PlayerID) {
            try {

                var conn = ConnectJDBC.getConnectJDBC().getConnection();
                CallableStatement callStmt = conn.prepareCall("{call FIND_BY_ID(?)}");
                callStmt.setInt("PlayerID", PlayerID);
                var resultSet = callStmt.executeQuery();
                if (resultSet.next()) {
                    String playerName = resultSet.getString("PlayerName");
                    Integer highScore = resultSet.getInt("HighScore");
                    Integer level = resultSet.getInt("Level");
                    Integer Id = resultSet.getInt("NationalId");
                    Player player = new Player(playerName, highScore, level, Id);
                    return player;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
