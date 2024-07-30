package com.example.Repository;

import java.util.List;

import com.example.Entity.Player;

public interface IPlayerRepository {
    void save(Player player);

    List<Player> findAll();

    Player findById(Integer playerId);

    void delete(Integer playerId);
}
