package com.example.Repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.Entity.Player;

public class PlayerRepository implements IPlayerRepository {
    @Override
    public List<Player> findAll() {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            List<Player> players = new ArrayList<>();
            CallableStatement callStmt = conn.prepareCall("{call GET_ALL_PLAYERS()}");
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setPlayer_id(rs.getInt("player_id"));
                player.setNational_id(rs.getInt("national_id"));
                player.setPlayer_name(rs.getString("player_name"));
                player.setHighscore(rs.getInt("highscore"));
                player.setLevel(rs.getInt("level"));
                players.add(player);
            }
            return players;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Player player) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call INSERT_PLAYER(?,?,?,?)}");
            callStmt.setInt("national_id", player.getNational_id());
            callStmt.setString("player_name", player.getPlayer_name());
            callStmt.setInt("highscore", player.getHighscore());
            callStmt.setInt("level", player.getLevel());
            callStmt.executeUpdate();
            callStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer playerId) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DELETE_PLAYER(?)}");
            callStmt.setInt("playerId", playerId);
            callStmt.execute();
            callStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player findById(Integer playerId) {
        try {

            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call SELECT_PLAYER_BYID(?)}");
            callStmt.setInt("playerId", playerId);
            var resultSet = callStmt.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("national_id");
                String player_name = resultSet.getString("player_name");
                Integer highscore = resultSet.getInt("highscore");
                Integer level = resultSet.getInt("level");
                Player player = new Player(id, player_name, highscore, level);
                return player;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}