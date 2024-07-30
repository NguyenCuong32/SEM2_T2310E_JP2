package com.example.repository;

import com.example.entity.Player;

public interface IPlayerRepository {
    List<Player> displayAll();
    void savePlayerList(Player player);
    Player findById(Integer PlayerID);
}
