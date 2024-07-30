package com.example.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.ConnectJDBC;
import com.example.entity.National;
import com.example.entity.Player;

public class StudentRepository implements IStudentRepository, INationalRepository {

    @Override
    public void addNational(National national){
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            if (conn != null && !conn.isClosed()){
                System.out.println("connected to DB");
                java.sql.CallableStatement statement = conn.prepareCall("{call INSERT_NATIONAL(?, ?)}");
                statement.setInt("NationalId", national.getNationalId());
                statement.setString("NationalName", national.getNationalName());
                statement.execute();
                statement.close();
                System.out.println("Inserted NATIONAL");
            }
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    @Override
    public void addPlayer(Player student) {
        // TODO Auto-generated method stub
        //1. ket noi db
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            if (conn != null && !conn.isClosed()){
                System.out.println("connected to DB");
                java.sql.CallableStatement statement = conn.prepareCall("{call INSERT_PLAYER(?, ?, ?, ?, ?)}");
                statement.setInt("PlayerId", student.getPlayerId());
                statement.setString("PlayerName", student.getPlayerName());
                statement.setInt("HighScore", student.getPlayerHighScore());
                statement.setInt("Level", student.getPlayerLevel());
                statement.setInt("NationalId", student.getPlayerNationalId());
                statement.execute();
                statement.close();
                System.out.println("Inserted STUDENT");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deletePlayer(int id) {
        // TODO Auto-generated method stub
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            if (conn != null && !conn.isClosed()){
                System.out.println("connected to DB");
                java.sql.CallableStatement statement = conn.prepareCall("{call GetPlayerByName(?)}");
                statement.setInt("p_id", id);
                statement.execute();
                statement.close();
                System.out.println("DELETED student with ID = "+ id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Player> getAllPlayer() {
        // TODO Auto-generated method stub
        ResultSet rs = null;
        List<Player> studentList = new ArrayList<>();
        try {
            var conn = ConnectJDBC.getInstance().getConnection();
            if (conn != null && !conn.isClosed()){
                System.out.println("connected to DB");
                java.sql.CallableStatement statement = conn.prepareCall("{call SHOW_PLAYER()}");
                rs = statement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("PlayerId");
                    String first_name = rs.getString("PlayerName");
                    int last_name = rs.getInt("HighScore");
                    int email = rs.getInt("Level");
                    String id_class = rs.getString("NationalName");
    
                    // Print the retrieved data
                    // System.out.println("ID: " + id);
                    // System.out.println("name: " + first_name);
                    // System.out.println("HighScore: " + last_name);
                    // System.out.println("level: " + email);

                    // Tạo đối tượng Student và thêm vào danh sách
                    Player player = new Player();
                    player.setPlayerId(id);
                    player.setPlayerName(first_name);
                    player.setPlayerLevel(email);
                    player.setPlayerHighScore(last_name);
                    player.setPlayerNationalName(id_class);
                    studentList.add(player);
                }
                System.out.println("SHOWED all students");
                statement.close();
                if (rs != null) rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    

    @Override
    public void updatePlayerInfo(int id, Player student) {
        // TODO Auto-generated method stub
        // try {
        //     var conn = ConnectJDBC.getInstance().getConnection();
        //     if (conn != null && !conn.isClosed()){
        //         System.out.println("connected to DB");
        //         java.sql.CallableStatement statement = conn.prepareCall("{call UPDATE_STUDENT(?, ?, ?, ?, ?)}");
        //         statement.setInt("p_id", id);
        //         statement.setString("p_first_name", student.getFirstName());
        //         statement.setString("p_last_name", student.getLastName());
        //         statement.setString("p_email", student.getEmail());
        //         statement.setInt("p_id_class", student.getIdClass());
        //         statement.execute();
        //         statement.close();
        //         System.out.println("UPDATED student with ID = "+ id);
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

}
