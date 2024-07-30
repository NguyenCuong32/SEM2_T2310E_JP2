package org.example.testjp2.repository;

import org.example.testjp2.entity.National;
import org.example.testjp2.entity.Player;

import java.util.List;

public interface MPlayerRepository {
    void insertPlayer(Player player);
//    List<Player> findAll();
    void deletePlayer(Integer PlayerId);
    void insertNation(National national);
    void deleteNational(Integer NationalId);
}
