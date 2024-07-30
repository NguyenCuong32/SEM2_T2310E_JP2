package com.hello.baithijavafx.Entities;

import com.hello.baithijavafx.ConnectDB.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IPlayerEntities {
    public void insertPlayer(Player player) {
        String query = "INSERT INTO Player (NationalId, PlayerName, HighScore, Level) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, player.getNationalId());
            statement.setString(2, player.getPlayerName());
            statement.setInt(3, player.getHighScore());
            statement.setInt(4, player.getLevel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM Player WHERE PlayerId = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
