package com.example;

import java.io.IOException;

import com.example.entity.Player;
import com.example.repository.PlayerRepository;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    TextField playerID;
    @FXML
    TextField nationalID;
    @FXML
    TextField playerName;
    @FXML
    TextField highScore;
    @FXML
    TextField level;

    @FXML
    private void addPlayer() throws IOException {
        PlayerRepository playerRepository = new PlayerRepository();
        Player player = new Player(Integer.parseInt(playerID.getText()), Integer.parseInt(nationalID.getText()), playerName.getText(), Integer.parseInt(highScore.getText()), Integer.parseInt(level.getText()));
        playerRepository.save(player);
        playerID.clear();
        nationalID.clear();
        playerName.clear();
        highScore.clear();
        level.clear();
    }

    @FXML
    private void showPlayer(){
        PlayerRepository playerRepository = new PlayerRepository();
        
    }



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
