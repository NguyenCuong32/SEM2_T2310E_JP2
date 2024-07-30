package com.example;

import java.io.IOException;

import com.example.entity.Player;
import com.example.repository.PlayerRepository;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    TextField PlayerName;

    @FXML
    TextField HighScore;

    @FXML
    TextField level;

    @FXML
    TextField nationalId;


    @FXML
    private void switchToSecondary() throws IOException {
        System.out.println("Demo player");
        PlayerRepository playerRepository = new PlayerRepository();
        Player player = new Player();
        player.setPlayerName(PlayerName.getText());
        player.setHighScore(Integer.getInteger(HighScore.getText()));
        player.setLevel(Integer.getInteger(level.getText()));
        player.setNationalId(Integer.getInteger(nationalId.getText()));
        playerRepository.savePlayerList(player);
        PlayerName.clear();
        HighScore.clear();
        level.clear();
        nationalId.clear(); // Fixed the missing semicolon
        // App.setRoot("secondary");
    }
    }

