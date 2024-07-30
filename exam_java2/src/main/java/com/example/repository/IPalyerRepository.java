package com.example.repository;

import java.util.List;

import com.example.entity.National;
import com.example.entity.Player;

public interface IPalyerRepository {
    void save(Player player);
    void delete(Integer playerId);
    Player findById(Integer playerId);
    List<Player> findAll();

}
