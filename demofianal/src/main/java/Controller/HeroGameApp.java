package Controller;

import Entity.Player;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HeroGameApp extends Application {

    private TableView<Player> playerTable;
    private ObservableList<Player> playerData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hero Game");

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));


        playerTable = new TableView<>();
        TableColumn<Player, Integer> idCol = new TableColumn<>("Player Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("playerId"));

        TableColumn<Player, String> nameCol = new TableColumn<>("Player Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<Player, Integer> scoreCol = new TableColumn<>("High Score");
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("highScore"));

        TableColumn<Player, Integer> levelCol = new TableColumn<>("Level");
        levelCol.setCellValueFactory(new PropertyValueFactory<>("level"));

        TableColumn<Player, String> nationalCol = new TableColumn<>("National");
        nationalCol.setCellValueFactory(new PropertyValueFactory<>("nationalName"));

        playerTable.getColumns().addAll(idCol, nameCol, scoreCol, levelCol, nationalCol);
        layout.setCenter(playerTable);
    }

}




