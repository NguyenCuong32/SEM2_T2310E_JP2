package Entity;

import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/HeroGame";
    private static final String USER = "root";
    private static final String PASSWORD = "Th252003@";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getPlayers() {
        String query = "SELECT Player.PlayerId, Player.PlayerName, Player.HighScore, Player.Level, National.NationalName " +
                "FROM Player JOIN National ON Player.NationalId = National.NationalId";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addPlayer(String playerName, int highScore, int level, int nationalId) {
        String query = "INSERT INTO Player (PlayerName, HighScore, Level, NationalId) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, playerName);
            pstmt.setInt(2, highScore);
            pstmt.setInt(3, level);
            pstmt.setInt(4, nationalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removePlayer(int playerId) {
        String query = "DELETE FROM Player WHERE PlayerId = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNational(String nationalName) {
        String query = "INSERT INTO National (NationalName) VALUES (?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nationalName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeNational(int nationalId) {
        String query = "DELETE FROM National WHERE NationalId = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, nationalId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
