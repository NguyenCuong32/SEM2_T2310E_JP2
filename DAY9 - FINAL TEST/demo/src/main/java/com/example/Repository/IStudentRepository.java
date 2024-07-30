package com.example.Repository;

import java.util.List;

import com.example.entity.Player;;

public interface IStudentRepository {  
    void addPlayer(Player student);
    List<Player> getAllPlayer();
    void deletePlayer(int id);
    void updatePlayerInfo(int id, Player player);
}
