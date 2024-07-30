package com.example.finaltest.Reponsitory;

import com.example.finaltest.Entity.Player;
import com.example.finaltest.Entity.PlayerList;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerReponsitory implements IPlayerReponsitory{
    @Override
    public String addPlayer(Player player) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement stmt = conn.prepareCall("{CALL Insert_Player(?, ?, ?, ?)}");
            stmt.setString("playername", player.getPlayerName());
            stmt.setInt("highscore", player.getHighScore());
            stmt.setInt("level", player.getLevel());
            stmt.setInt("nationalID", player.getNationalID());
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return ("A new player was add !");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ("OK!");
    }

    @Override
    public String removePlayer(String playername) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement stmt = conn.prepareCall("{CALL Delete_Player(?)}");
            stmt.setString(1, playername);
            stmt.executeUpdate();
            stmt.close();
            return "A player was deleted";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @Override
    public List<PlayerList> findPlayer(String playername) {
        List<PlayerList> players = new ArrayList<>();
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement stmt = conn.prepareCall("{CALL Find_Player(?)}");
            stmt.setString(1, playername);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PlayerList player = new PlayerList();
                player.setNational(rs.getString("NationalName"));
                player.setPlayerName(rs.getString("PlayerName"));
                player.setHighScore(rs.getInt("HighScore"));
                player.setLevel(rs.getInt("Level"));
                players.add(player);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<PlayerList> getAllPlayers() {
        return List.of();
    }

    @Override
    public List<PlayerList> getTopTenPlayers() {
        return List.of();
    }
}
