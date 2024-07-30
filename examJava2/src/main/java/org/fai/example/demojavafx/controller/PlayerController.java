package org.fai.example.demojavafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.fai.example.demojavafx.entity.Player;
import org.fai.example.demojavafx.repository.PlayerRepository;

import java.util.List;

public class PlayerController {
    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtPlayerName;
    @FXML
    private TextField txtHighScore;
    @FXML
    private TextField txtLevel;
    @FXML
    private TextField txtNationalId;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtPlayerId;
    @FXML
    private TableView<Player> tableView;

    @FXML
    public void initialize() {
        // Uncomment to initialize players data if needed
        // initPlayer();
    }

    public void insertPlayer(Player player) {
        try {
            PlayerRepository playerRepository = new PlayerRepository();
            playerRepository.save(player);
            lblMessage.setText("Player inserted successfully");
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void onAddPlayer() {
        Player player = new Player(
                null,
                txtPlayerName.getText(),
                Integer.parseInt(txtHighScore.getText()),
                Integer.parseInt(txtLevel.getText()),
                Integer.parseInt(txtNationalId.getText())
        );
        insertPlayer(player);
    }

    public void onDeletePlayer() {
        try {
            PlayerRepository playerRepository = new PlayerRepository();
            playerRepository.delete(Integer.parseInt(txtPlayerId.getText()));
            lblMessage.setText("Player deleted successfully");
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void onShowAllData() {
        initPlayer();
    }

    public void initPlayer() {
        PlayerRepository playerRepository = new PlayerRepository();
        List<Player> players = playerRepository.findAll();

        TableColumn<Player, Integer> id = new TableColumn<>("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("playerId"));

        TableColumn<Player, String> playerName = new TableColumn<>("Player Name");
        playerName.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<Player, Integer> highScore = new TableColumn<>("High Score");
        highScore.setCellValueFactory(new PropertyValueFactory<>("highScore"));

        TableColumn<Player, Integer> level = new TableColumn<>("Level");
        level.setCellValueFactory(new PropertyValueFactory<>("level"));

        TableColumn<Player, Integer> nationalId = new TableColumn<>("National Id");
        nationalId.setCellValueFactory(new PropertyValueFactory<>("nationalId"));

        ObservableList<Player> dataPlayers = FXCollections.observableArrayList(players);

        tableView.getColumns().clear(); // Clear existing columns
        tableView.getColumns().addAll(id, playerName, highScore, level, nationalId);
        tableView.setItems(dataPlayers);
    }
}
