package org.example.testjp2.repository;

import org.example.testjp2.entity.National;
import org.example.testjp2.entity.Player;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements MPlayerRepository {
    @Override
    public void insertPlayer(Player player) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call INSERT_PLAYER(?,?,?,?)}");
            callStmt.setInt("NationalID", player.getNationalID());
            callStmt.setString("PlayerName", player.getPlayerName());
            callStmt.setInt("HighScore", player.getHighScore());
            callStmt.setInt("Plevel", player.getPlevel());
            callStmt.executeUpdate();
            callStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePlayer(Integer PlayerId) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DELETE_PLAYER(?)}");
            callStmt.setInt("PlayerID", PlayerId);
            callStmt.execute();
            callStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertNation(National national) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call INSERT_NATIONAL(?)}");
            callStmt.setString("NationNames", national.getNationNames());
            callStmt.executeUpdate();
            callStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNational(Integer NationalId) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DELETE_NATIONAL(?)}");
            callStmt.setInt("NationalID", NationalId);
            callStmt.execute();
            callStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
