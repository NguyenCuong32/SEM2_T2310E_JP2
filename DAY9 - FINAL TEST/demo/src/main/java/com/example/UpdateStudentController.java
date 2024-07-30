package com.example;

import java.io.IOException;

import com.example.Repository.StudentRepository;
import com.example.entity.Player;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateStudentController {

    @FXML
    private TextField text_id;

    @FXML
    private TextField text_first_name;
    @FXML
    private TextField text_last_name;
    @FXML
    private TextField text_email;
    @FXML
    private TextField text_class_id;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("addstudent");
    }

    @FXML
    private void switchTo_liststudent() throws IOException {
        App.setRoot("liststudent");
    }

    @FXML
    private void switchTo_deletestudent() throws IOException {
        App.setRoot("deletestudent");
    }

    @FXML 
    private void updateStudent(){
        // Object student để thay thế
        Player student = new Player();
        // student.setPlayerId(0);
        // student.setPlayerName(text_first_name.getText());
        // student.setPlayerLevel(text_last_name.getText());
        // student.setPlayerHighScore(text_email.getText());
        // student.setPlayerNationalId(Integer.parseInt(text_class_id.getText()));

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.updatePlayerInfo(Integer.parseInt(text_id.getText()), student);
    }

}