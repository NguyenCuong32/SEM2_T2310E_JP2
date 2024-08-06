

import Entity.DatabaseHelper;
import Entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPlayer {
    public static void InsertPlayer(Player player) {
        String sql = "INSERT INTO Player (NationalId, PlayerName, HighScore, Level) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.connect();
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

    public void main() {
    }
}
public static void deletePlayer(int playerId) {
    String sql = "DELETE FROM Player WHERE PlayerId = ?";

    try (Connection conn = DatabaseHelper.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, playerId);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void main() {
}



