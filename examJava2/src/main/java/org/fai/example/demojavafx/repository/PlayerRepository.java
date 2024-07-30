package org.fai.example.demojavafx.repository;

import org.fai.example.demojavafx.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements IPlayerRepository {
    @Override
    public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO Player (PlayerName, HighScore, Level, NationalId) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectJDBC.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, player.getPlayerName());
            pstmt.setInt(2, player.getHighScore());
            pstmt.setInt(3, player.getLevel());
            pstmt.setInt(4, player.getNationalId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Player> findAll() {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            List<Player> players = new ArrayList<>();
            CallableStatement callStmt = conn.prepareCall("SELECT PlayerId, PlayerName, HighScore, Level, NationalName FROM Player " +
                    "JOIN National ON Player.NationalId = National.NationalId ORDER BY HighScore DESC LIMIT 10");
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                Player player = new Player(
                        rs.getInt("PlayerId"),
                        rs.getString("PlayerName"),
                        rs.getInt("HighScore"),
                        rs.getInt("Level"),
                        rs.getInt("NationalId")
                );
                players.add(player);
            }
            return players;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Integer PlayerId) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Player WHERE PlayerId = ?");
            pstmt.setInt(1, PlayerId);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void save(Player player) throws SQLException {
        addPlayer(player);
    }
}
