package com.example.finaltest.Controller;

import com.example.finaltest.Entity.Player;
import com.example.finaltest.Entity.PlayerList;
import com.example.finaltest.Reponsitory.PlayerReponsitory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PlayerController {
    @FXML
    private TextField name;
    @FXML
    private TextField score;
    @FXML
    private TextField level;
    @FXML
    private TextField nationalID;
    @FXML
    private TextField playername;
    @FXML
    private Label Information;
    @FXML
    private TableView<PlayerList> playerTable;
    @FXML
    public void addPlayer() {
        String Playername = name.getText();
        Integer Highscore = Integer.valueOf(score.getText());
        Integer Level = Integer.valueOf(level.getText());
        Integer NationalID = Integer.valueOf(nationalID.getText());

        PlayerReponsitory playerReponsitory = new PlayerReponsitory();
        Player player = new Player(Playername, Highscore, Level, NationalID);

        String result = playerReponsitory.addPlayer(player);
        Information.setText(result);
    }
    @FXML
    public void deletePlayer() {
        String Playername = playername.getText();

        PlayerReponsitory playerReponsitory = new PlayerReponsitory();

        String result = playerReponsitory.removePlayer(Playername);
        Information.setText(result);
    }
    @FXML
    public void findPlayer() {
        String Playername = playername.getText();

        PlayerReponsitory playerReponsitory = new PlayerReponsitory();
        List<PlayerList> playerLists = playerReponsitory.findPlayer(Playername);

        TableColumn<PlayerList, String> playerNameColumn = new TableColumn<>("Player Name");
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("PlayerName"));

        TableColumn<PlayerList, Integer> highScoreColum = new TableColumn<>("High Score");
        highScoreColum.setCellValueFactory(new PropertyValueFactory<>("HighScore"));

        TableColumn<PlayerList, Integer> LevelColumn = new TableColumn<>("Level");
        LevelColumn.setCellValueFactory(new PropertyValueFactory<>("Level"));

        TableColumn<PlayerList, Integer> NationalColumn = new TableColumn<>("National");
        NationalColumn.setCellValueFactory(new PropertyValueFactory<>("National"));

        playerTable.getColumns().addAll(playerNameColumn, highScoreColum, LevelColumn, NationalColumn);

        ObservableList<PlayerList> observablePlayerList  = FXCollections.observableArrayList(playerLists);
        playerTable.setItems(observablePlayerList );

        playerTable.setRowFactory(tv -> {
            TableRow<PlayerList> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                PlayerList rowData = row.getItem();

            });
            return row;
        });
    }
}
