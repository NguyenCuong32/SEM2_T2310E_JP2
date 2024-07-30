package com.example;

import java.sql.SQLException;
import com.example.entity.National;
import com.example.entity.Player;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HeroGameApp extends Application {

    private PlayerDatabase playerDatabase = new PlayerDatabase();
    private TableView<Player> playerTable = new TableView<>();
    private TableView<National> nationalTable = new TableView<>();
    private TextField nationalTextField = new TextField();

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hero Game");

        BorderPane root = new BorderPane();
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        Label playerNameLabel = new Label("Player Name:");
        TextField playerNameField = new TextField();
        Label highScoreLabel = new Label("High Score:");
        TextField highScoreField = new TextField();
        Label levelLabel = new Label("Level:");
        TextField levelField = new TextField();
        Label nationalLabel = new Label("National:");

        Button addPlayerBtn = new Button("Add Player");
        Button removePlayerBtn = new Button("Remove Player");
        Button addNationalBtn = new Button("Add National");
        Button removeNationalBtn = new Button("Remove National");

        TableColumn<Player, Integer> idCol = new TableColumn<>("Player Id");
        TableColumn<Player, String> nameCol = new TableColumn<>("Player Name");
        TableColumn<Player, Integer> scoreCol = new TableColumn<>("High Score");
        TableColumn<Player, Integer> levelCol = new TableColumn<>("Level");
        TableColumn<Player, String> nationalCol = new TableColumn<>("National");

        idCol.setCellValueFactory(cellData -> cellData.getValue().playerIdProperty().asObject());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().playerNameProperty());
        scoreCol.setCellValueFactory(cellData -> cellData.getValue().highScoreProperty().asObject());
        levelCol.setCellValueFactory(cellData -> cellData.getValue().levelProperty().asObject());
        nationalCol.setCellValueFactory(cellData -> cellData.getValue().nationalProperty());

        playerTable.getColumns().addAll(idCol, nameCol, scoreCol, levelCol, nationalCol);

        TableColumn<National, Integer> nationalIdCol = new TableColumn<>("National Id");
        TableColumn<National, String> nationalNameCol = new TableColumn<>("National Name");

        nationalIdCol.setCellValueFactory(cellData -> cellData.getValue().nationalIdProperty().asObject());
        nationalNameCol.setCellValueFactory(cellData -> cellData.getValue().nationalNameProperty());

        nationalTable.getColumns().addAll(nationalIdCol, nationalNameCol);

        nationalTextField.setPromptText("Enter National Name");

        vbox.getChildren().addAll(playerNameLabel, playerNameField, highScoreLabel, highScoreField, levelLabel, levelField, nationalLabel, nationalTextField, addPlayerBtn, removePlayerBtn, addNationalBtn, removeNationalBtn, playerTable, nationalTable);
        root.setCenter(vbox);

        loadNationalData();
        loadPlayerData();

        addPlayerBtn.setOnAction(e -> {
            try {
                String playerName = playerNameField.getText();
                int highScore = Integer.parseInt(highScoreField.getText());
                int level = Integer.parseInt(levelField.getText());
                String nationalName = nationalTextField.getText();

                if (!nationalName.isEmpty()) {
                    National national = playerDatabase.getNationalByName(nationalName);
                    if (national != null) {
                        playerDatabase.addPlayer(national.getNationalId(), playerName, highScore, level);
                        loadPlayerData();
                    } else {
                        showAlert("Error", "National not found. Please add the national first.");
                    }
                } else {
                    showAlert("Error", "Please enter a national name.");
                }
            } catch (NumberFormatException ex) {
                showAlert("Error", "High Score and Level must be numbers.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        removePlayerBtn.setOnAction(e -> {
            Player selectedPlayer = playerTable.getSelectionModel().getSelectedItem();
            if (selectedPlayer != null) {
                try {
                    playerDatabase.removePlayer(selectedPlayer.getPlayerId());
                    loadPlayerData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                showAlert("Error", "Please select a player to remove.");
            }
        });

        addNationalBtn.setOnAction(e -> {
            String nationalName = nationalTextField.getText();
        

            if (!nationalName.isEmpty()) {
                try {
                    playerDatabase.addNational(nationalName);
                    loadNationalData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                showAlert("Error", "Please enter a national name.");
            }
        });

        removeNationalBtn.setOnAction(e -> {
            National selectedNational = nationalTable.getSelectionModel().getSelectedItem();
            if (selectedNational != null) {
                try {
                    playerDatabase.removeNational(selectedNational.getNationalId());
                    loadNationalData();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                showAlert("Error", "Please select a national to remove.");
            }
        });

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void loadPlayerData() {
        try {
            playerTable.getItems().setAll(playerDatabase.getPlayers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadNationalData() {
        try {
            nationalTable.getItems().setAll(playerDatabase.getNationals());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
