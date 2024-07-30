package com.example.javafx30072024.service;

import com.example.javafx30072024.dto.PlayerDTO;
import com.example.javafx30072024.entity.Player;

import java.util.List;

public interface PlayerRepository {
    void save(Player player);
    void delete(Long playerId);

    List<PlayerDTO> findAll();
}
