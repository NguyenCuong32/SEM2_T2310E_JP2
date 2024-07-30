package org.fai.example.demojavafx.repository;

import org.fai.example.demojavafx.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface IPlayerRepository {
    void addPlayer(Player player) throws SQLException;
    List<Player> findAll();
    void delete(Integer PlayerId);
    void save(Player player) throws SQLException;
}
