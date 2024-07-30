package com.example.finaltest.Reponsitory;

import com.example.finaltest.Entity.Player;
import com.example.finaltest.Entity.PlayerList;

import java.util.List;

public interface IPlayerReponsitory {
    String addPlayer (Player player);
    String removePlayer(String playername);
    List<PlayerList> findPlayer (String playername);
    List<PlayerList> getAllPlayers();
    List<PlayerList> getTopTenPlayers();
}
