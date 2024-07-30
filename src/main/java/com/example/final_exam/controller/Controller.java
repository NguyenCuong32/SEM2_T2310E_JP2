package com.example.final_exam.controller;

import com.example.final_exam.model.NationalModel;
import com.example.final_exam.model.PlayerModel;
import com.example.final_exam.repo.NationalRepo;
import com.example.final_exam.repo.PlayerRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class Controller {
    @FXML
    private Label lblMessage;

    @FXML
    private TextField txtPlayerId, txtPlayerName, txtPlayerNationalId, txtHighScore, txtLevel;

    @FXML
    private TextField txtPlayerIdToDelete, txtPlayerNameToFind;

    @FXML
    private TextField txtNationalName, txtNationalId;

    @FXML
    private TableView<PlayerModel> tableView;

    @FXML
    TableView<NationalModel> tableViewNational;

    private PlayerModel selectedModel;

    private final PlayerRepo playerRepo = new PlayerRepo();
    private final NationalRepo nationalRepo = new NationalRepo();

    public void insertPlayer(PlayerModel model) {
        try {
            playerRepo.save(model);
            lblMessage.setText("Inserted Player successfully");
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void insertNational(NationalModel model) {
        try {
            nationalRepo.save(model);
            lblMessage.setText("Inserted National successfully");
            initTable();
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void onAddNational() {
        NationalModel model = new NationalModel(txtNationalName.getText());
        insertNational(model);
    }

    public void onDeleteNational() {
        try {
            nationalRepo.delete(Integer.parseInt(txtNationalId.getText()));
            initTable();
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }


    public void onAddPlayer() {
        PlayerModel model = new PlayerModel(Integer.parseInt(txtPlayerNationalId.getText()), txtPlayerName.getText(),
                Integer.parseInt(txtHighScore.getText()), Integer.parseInt(txtLevel.getText()));
        insertPlayer(model);
    }

    public void onDeletePlayer() {
        try {
            playerRepo.delete(Integer.parseInt(txtPlayerIdToDelete.getText()));
        } catch (Exception e) {
            lblMessage.setText(e.getMessage());
        }
    }

    public void onFindByName() {
        initTableFindByName();
    }

    public void initTableFindByName() {
        tableView.getItems().clear();
        PlayerModel player = playerRepo.findByName(txtPlayerNameToFind.getText());

        if (tableView.getColumns().isEmpty()) {
            TableColumn<PlayerModel, Integer> id = new TableColumn<>("Player Id");
            id.setCellValueFactory(new PropertyValueFactory<>("PlayerId"));

            TableColumn<PlayerModel, String> name = new TableColumn<>("Player Name");
            name.setCellValueFactory(new PropertyValueFactory<>("PlayerName"));

            TableColumn<PlayerModel, String> nationalId = new TableColumn<>("National Id");
            nationalId.setCellValueFactory(new PropertyValueFactory<>("NationalId"));

            TableColumn<PlayerModel, String> highScore = new TableColumn<>("High Score");
            highScore.setCellValueFactory(new PropertyValueFactory<>("HighScore"));

            TableColumn<PlayerModel, String> level = new TableColumn<>("Level");
            level.setCellValueFactory(new PropertyValueFactory<>("Level"));

            tableView.getColumns().addAll(id, name, nationalId, highScore, level);
        }

        ObservableList<PlayerModel> dataList = FXCollections.observableArrayList(player);

        tableView.setItems(dataList);
    }


    public void onShowAllPlayer() {
        initTable();
    }

    public void initTable() {
        tableView.getItems().clear();
        List<PlayerModel> playerList = playerRepo.findAll();

        if (tableView.getColumns().isEmpty()) {
            TableColumn<PlayerModel, Integer> id = new TableColumn<>("Player Id");
            id.setCellValueFactory(new PropertyValueFactory<>("PlayerId"));

            TableColumn<PlayerModel, String> name = new TableColumn<>("Player Name");
            name.setCellValueFactory(new PropertyValueFactory<>("PlayerName"));

            TableColumn<PlayerModel, String> nationalId = new TableColumn<>("National Id");
            nationalId.setCellValueFactory(new PropertyValueFactory<>("NationalId"));

            TableColumn<PlayerModel, String> highScore = new TableColumn<>("High Score");
            highScore.setCellValueFactory(new PropertyValueFactory<>("HighScore"));

            TableColumn<PlayerModel, String> level = new TableColumn<>("Level");
            level.setCellValueFactory(new PropertyValueFactory<>("Level"));

            tableView.getColumns().addAll(id, name, nationalId, highScore, level);
        }

        ObservableList<PlayerModel> dataList = FXCollections.observableArrayList(playerList);

        tableView.setItems(dataList);
    }

    public void onShowTop10Player() {
        initTableTop10();
    }

    public void initTableTop10() {
        tableView.getItems().clear();
        List<PlayerModel> playerList = playerRepo.findTop10();

        if (tableView.getColumns().isEmpty()) {
            TableColumn<PlayerModel, Integer> id = new TableColumn<>("Player Id");
            id.setCellValueFactory(new PropertyValueFactory<>("PlayerId"));

            TableColumn<PlayerModel, String> name = new TableColumn<>("Player Name");
            name.setCellValueFactory(new PropertyValueFactory<>("PlayerName"));

            TableColumn<PlayerModel, String> nationalId = new TableColumn<>("National Id");
            nationalId.setCellValueFactory(new PropertyValueFactory<>("NationalId"));

            TableColumn<PlayerModel, String> highScore = new TableColumn<>("High Score");
            highScore.setCellValueFactory(new PropertyValueFactory<>("HighScore"));

            TableColumn<PlayerModel, String> level = new TableColumn<>("Level");
            level.setCellValueFactory(new PropertyValueFactory<>("Level"));

            tableView.getColumns().addAll(id, name, nationalId, highScore, level);
        }

        ObservableList<PlayerModel> dataList = FXCollections.observableArrayList(playerList);

        tableView.setItems(dataList);
    }


    public void onShowAllNational() {
        initTableNational();
    }

    public void initTableNational() {
        tableViewNational.getItems().clear();
        List<NationalModel> nationalList = nationalRepo.findAll();

        if (tableViewNational.getColumns().isEmpty()) {
            TableColumn<NationalModel, Integer> id = new TableColumn<>("National Id");
            id.setCellValueFactory(new PropertyValueFactory<>("NationalId"));

            TableColumn<NationalModel, String> name = new TableColumn<>("National Name");
            name.setCellValueFactory(new PropertyValueFactory<>("NationalName"));

            tableViewNational.getColumns().addAll(id, name);
        }

        ObservableList<NationalModel> dataList = FXCollections.observableArrayList(nationalList);

        tableViewNational.setItems(dataList);
    }
}