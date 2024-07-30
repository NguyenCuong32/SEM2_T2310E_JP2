package com.hello.baithijavafx.Controller;

import com.hello.baithijavafx.Entities.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private TextField playerNameField;
    @FXML
    private TextField playerHighScoreField;
    @FXML
    private TextField playerLevelField;
    @FXML
    private TextField playerNationalField;

    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, Integer> playerIdColumn;
    @FXML
    private TableColumn<Player, String> playerNameColumn;
    @FXML
    private TableColumn<Player, Integer> highScoreColumn;
    @FXML
    private TableColumn<Player, Integer> levelColumn;
    @FXML
    private TableColumn<Player, String> nationalColumn;

    private PlayerDAO playerDAO = new PlayerDAO();

    @FXML
    public void initialize() {
        playerIdColumn.setCellValueFactory(new PropertyValueFactory<>("playerId"));
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        highScoreColumn.setCellValueFactory(new PropertyValueFactory<>("highScore"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
        nationalColumn.setCellValueFactory(new PropertyValueFactory<>("nationalName"));

        playerTable.setItems(FXCollections.observableArrayList());
    }

    @FXML
    private void handleFindPlayer() {
        String playerName = playerNameField.getText();
        ObservableList<Player> players = playerDAO.displayAllByPlayerName(playerName);
        playerTable.setItems(players);
    }

    @FXML
    private void handleAddPlayer() {
        try {
            String playerName = playerNameField.getText();
            int highScore = Integer.parseInt(playerHighScoreField.getText());
            int level = Integer.parseInt(playerLevelField.getText());
            int nationalId = Integer.parseInt(playerNationalField.getText());

            Player newPlayer = new Player(nationalId, playerName, highScore, level);
            playerDAO.insertPlayer(newPlayer);
            handleDisplayAll();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeletePlayer() {
        Player selectedPlayer = playerTable.getSelectionModel().getSelectedItem();
        if (selectedPlayer != null) {
            playerDAO.deletePlayer(selectedPlayer.getPlayerId());
            handleDisplayAll();
        } else {
            System.out.println("error");
        }
    }

    private void handleDisplayAll() {
        ObservableList<Player> players = playerDAO.displayAll();
        playerTable.setItems(players);
    }

    public void handleDeleteNational() {

    }
}
