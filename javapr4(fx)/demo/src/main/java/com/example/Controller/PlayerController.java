package com.example.Controller;

import com.example.Entity.Player;
import com.example.Repository.PlayerRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PlayerController {
    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtPlayerName;
    @FXML
    private TextField txtHighscore;
    @FXML
    private TextField txtLevel;
    @FXML
    private TextField txtNationalId;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtPlayerId;
    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {
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
        Player layer = new Player(txtPlayerName.getText(), txtHighscore.getText(), txtLevel.getText(),
                Integer.parseInt(txtNationalId.getText()));
        insertStudent(player);
    }

    public void onDeletePlayer() {
        try {
            PlayerRepository playerRepository = new PlayerRepository();
            playerRepository.delete(Integer.parseInt(txtPlayerId.getText()));
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void onGetPlayer() {
        PlayerRepository studentRepository = new PlayerRepository();
        Player student = studentRepository.findById(Integer.parseInt(txtPlayerId.getText()));
        txtPlayerName.setText(student.getPlayer_name());
        txtHighscore.setText(student.getHighscore().toString());
        txtNationalId.setText(student.getNational_id().toString());
    }

    public void onUpdatePlayer() {
        try {
            PlayerRepository playerRepository = new PlayerRepository();
            String PlayerName = txtPlayerName.getText();
            Integer highscore = Integer.parseInt(txtHighscore.getText());
            Integer NationalId = Integer.parseInt(txtNationalId.getText());
            Integer PlayerId = Integer.parseInt(txtPlayerId.getText());

            Player player = new Player(playerId, player, highscore, NationalId);
            player.setId(playerId);
            playerRepository.update(player);
            lblMessage.setText("Player updated successfully");
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void onShowAllData() {
        initPlayer();
    }

}
