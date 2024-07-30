package com.example;

import java.io.IOException;

import com.example.Repository.StudentRepository;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DeleteStudentController {

    @FXML
    private TextField text_id;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("addstudent");
    }

    @FXML
    private void switchTo_liststudent() throws IOException{
        App.setRoot("liststudent");
    }

    @FXML
    private void switchTo_updatestudent() throws IOException{
        App.setRoot("updatestudent");
    }

    @FXML
    private void deleteStudent(){
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.deletePlayer(Integer.parseInt(text_id.getText()));
    }
}