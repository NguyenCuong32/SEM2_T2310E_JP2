package com.example.javafx30072024.controller;

import com.example.javafx30072024.dto.PlayerDTO;
import com.example.javafx30072024.entity.Player;
import com.example.javafx30072024.service.RepositoryDetailImpl.PlayerRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField txtPlayerId;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtStudentId;
    @FXML
    private TableView tableView;

    @FXML
    public void initialize() {

    }

    public void insertPlayer(Player player) {
        try {
            PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
            playerRepository.save(player);
            lblMessage.setText("Player inserted successfully");
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void addPlayer() {
        Player student = new Player(txtPlayerName.getText(), txtHighScore.getText(), txtLevel.getText(), Long.parseLong(txtNationalId.getText()));
        insertPlayer(student);
    }

    public void deletePlayer(Long playerId) {
        try {
            PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
            playerRepository.delete(playerId);
            lblMessage.setText("Delete player successfully");
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }
    public void onShowAllData(){
        initStudent();
    }
    public void initStudent() {
        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();
        List<PlayerDTO> students = playerRepository.findAll();
        TableColumn<PlayerDTO, Integer> id = new TableColumn<>("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("player_id"));

        TableColumn<PlayerDTO, String> playerName = new TableColumn<>("Player_Name");
        playerName.setCellValueFactory(new PropertyValueFactory<>("player_name"));

        TableColumn<PlayerDTO, String> highscore = new TableColumn<>("Score");
        highscore.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<PlayerDTO, String> level = new TableColumn<>("Level");
        level.setCellValueFactory(new PropertyValueFactory<>("level"));

        TableColumn<PlayerDTO, String> national = new TableColumn<>("national");
        national.setCellValueFactory(new PropertyValueFactory<>("national"));

        ObservableList<PlayerDTO> dataStudents = FXCollections.observableArrayList(students);

        tableView.getColumns().addAll(id, playerName, highscore, level, national);

        tableView.setItems(dataStudents);
    }

    public void deletePlayer() {
        deletePlayer(Long.parseLong(txtPlayerId.getText()));
    }

}
