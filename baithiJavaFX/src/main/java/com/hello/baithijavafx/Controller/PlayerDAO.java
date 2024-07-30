package com.hello.baithijavafx.Controller;

import com.hello.baithijavafx.ConnectDB.DatabaseConnection;
import com.hello.baithijavafx.Entities.National;
import com.hello.baithijavafx.Entities.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class PlayerDAO {


    public void insertPlayer(Player player) {
        String sql = "INSERT INTO Player (NationalId, PlayerName, HighScore, Level) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, player.getNationalId());
            pstmt.setString(2, player.getPlayerName());
            pstmt.setInt(3, player.getHighScore());
            pstmt.setInt(4, player.getLevel());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM Player WHERE PlayerId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertNational(National national) {
        String sql = "INSERT INTO National (NationalName) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, national.getNationalName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNational(int nationalId) {
        String sql = "DELETE FROM National WHERE NationalId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, nationalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<Player> displayAll() {
        ObservableList<Player> playerList = FXCollections.observableArrayList();
        String sql = "SELECT p.*, n.NationalName FROM Player p JOIN National n ON p.NationalId = n.NationalId";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("PlayerId"));
                player.setNationalId(rs.getInt("NationalId"));
                player.setPlayerName(rs.getString("PlayerName"));
                player.setHighScore(rs.getInt("HighScore"));
                player.setLevel(rs.getInt("Level"));
                player.setNationalName(rs.getString("NationalName"));
                playerList.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerList;
    }


    public ObservableList<Player> displayAllByPlayerName(String playerName) {
        ObservableList<Player> playerList = FXCollections.observableArrayList();
        String sql = "SELECT p.*, n.NationalName FROM Player p JOIN National n ON p.NationalId = n.NationalId WHERE p.PlayerName LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + playerName + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("PlayerId"));
                player.setNationalId(rs.getInt("NationalId"));
                player.setPlayerName(rs.getString("PlayerName"));
                player.setHighScore(rs.getInt("HighScore"));
                player.setLevel(rs.getInt("Level"));
                player.setNationalName(rs.getString("NationalName"));
                playerList.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerList;
    }


    public ObservableList<Player> displayTop10() {
        ObservableList<Player> playerList = FXCollections.observableArrayList();
        String sql = "SELECT p.*, n.NationalName FROM Player p JOIN National n ON p.NationalId = n.NationalId ORDER BY p.HighScore DESC LIMIT 10";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("PlayerId"));
                player.setNationalId(rs.getInt("NationalId"));
                player.setPlayerName(rs.getString("PlayerName"));
                player.setHighScore(rs.getInt("HighScore"));
                player.setLevel(rs.getInt("Level"));
                player.setNationalName(rs.getString("NationalName"));
                playerList.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playerList;
    }
}