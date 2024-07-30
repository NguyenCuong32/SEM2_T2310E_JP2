package com.example.javafx30072024.service.RepositoryDetailImpl;

import com.example.javafx30072024.dto.PlayerDTO;
import com.example.javafx30072024.entity.Player;
import com.example.javafx30072024.service.ConnectJDBC;
import com.example.javafx30072024.service.PlayerRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    @Override
    public void save(Player player) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call InsertPlayer(?,?,?,?)}");
            callStmt.setLong("p_national_id", player.getNationalId());
            callStmt.setString("p_player_name", player.getPlayerName());
            callStmt.setString("p_highscore", player.getHighScore());
            callStmt.setString("p_level", player.getLevel());
            callStmt.executeQuery();
            callStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long playerId) {
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            CallableStatement callStmt = conn.prepareCall("{call DeletePlayerById(?)}");
            callStmt.setLong("p_playerId", playerId);
            callStmt.execute();
            callStmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PlayerDTO> findAll() {
        try{
            var conn = ConnectJDBC.getInstance().getConnection();
            List<PlayerDTO> playerList = new ArrayList<>();
            CallableStatement callStmt = conn.prepareCall("{call ShowPlayerWithNational1()}");
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                playerList.add(new PlayerDTO(
                        rs.getLong("player_Id"),
                        rs.getString("player_Name"),
                        rs.getString("highScore"),
                        rs.getString("level"),
                        rs.getString("national_Name")
                ));
            }
            return playerList;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
