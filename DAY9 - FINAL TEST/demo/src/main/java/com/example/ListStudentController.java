package com.example;

import java.io.IOException;
import java.util.List;


import com.example.Repository.StudentRepository;
import com.example.entity.Player;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class ListStudentController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("addstudent");
    }

    @FXML
    private void switchTo_deletestudent() throws IOException{
        App.setRoot("deletestudent");
    }

    @FXML
    private void switchTo_updatestudent() throws IOException{
        App.setRoot("updatestudent");
    }

    @FXML
    private VBox root;

    @FXML
    private TableView<Player> studentTable;

    @FXML
    private TableColumn<Player, Integer> idColumn;

    @FXML
    private TableColumn<Player, String> firstNameColumn;

    @FXML
    private TableColumn<Player, String> lastNameColumn;

    @FXML
    private TableColumn<Player, String> emailColumn;

    @FXML
    private TableColumn<Player, Integer> idClassColumn;





    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("PlayerId"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("PlayerName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("PlayerHighScore"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("PlayerLevel"));
        idClassColumn.setCellValueFactory(new PropertyValueFactory<>("PlayerNationalName"));
    }

    
    @FXML
    private void showAllStudent(){
        StudentRepository studentRepository = new StudentRepository();
        List<Player> students = studentRepository.getAllPlayer();
        
        for (Player student : students) {
            studentTable.getItems().add(student);
        }
    }

}