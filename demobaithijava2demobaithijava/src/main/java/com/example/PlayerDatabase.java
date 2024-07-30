package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.entity.National;
import com.example.entity.Player;

public class PlayerDatabase {

    public void addPlayer(int nationalId, String playerName, int highScore, int level) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL AddPlayer(?, ?, ?, ?)}")) {
            stmt.setInt(1, nationalId);
            stmt.setString(2, playerName);
            stmt.setInt(3, highScore);
            stmt.setInt(4, level);
            stmt.execute();
        }
    }

    public void removePlayer(int playerId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL RemovePlayer(?)}")) {
            stmt.setInt(1, playerId);
            stmt.execute();
        }
    }

    public void addNational(String nationalName) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL AddNational(?)}")) {
            stmt.setString(1, nationalName);
            stmt.execute();
        }
    }

    public void removeNational(int nationalId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall("{CALL RemoveNational(?)}")) {
            stmt.setInt(1, nationalId);
            stmt.execute();
        }
    }

    @SuppressWarnings("exports")
    public List<Player> getPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                players.add(new Player(
                    rs.getInt("PlayerId"),
                    rs.getString("PlayerName"),
                    rs.getInt("HighScore"),
                    rs.getInt("Level"),
                    rs.getString("National")
                ));
            }
        }
        return players;
    }

    @SuppressWarnings("exports")
    public List<National> getNationals() throws SQLException {
        List<National> nationals = new ArrayList<>();
        String sql = "SELECT * FROM National";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nationals.add(new National(
                    rs.getInt("NationalId"),
                    rs.getString("NationalName")
                ));
            }
        }
        return nationals;
    }

    @SuppressWarnings("exports")
    public National getNationalByName(String nationalName) throws SQLException {
        String sql = "SELECT * FROM National WHERE NationalName = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nationalName);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new National(
                        rs.getInt("NationalId"),
                        rs.getString("NationalName")
                    );
                }
            }
        }
        return null;
    }
}
