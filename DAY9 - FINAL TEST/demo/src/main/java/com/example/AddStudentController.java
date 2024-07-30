package com.example;

import java.io.IOException;

import com.example.Repository.StudentRepository;
import com.example.entity.National;
import com.example.entity.Player;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddStudentController {

    // @FXML
    // private void switchToSecondary() throws IOException {
    //     App.setRoot("secondary");
    // }
    @FXML
    private TextField text_player_name;
    @FXML
    private TextField text_player_highscore;
    @FXML
    private TextField text_player_level;
    @FXML
    private TextField text_national_id;

    @FXML
    private TextField text_national_name;

    @FXML
    private void addStudent() {


        String first_name = text_player_name.getText();
        String last_name = text_player_highscore.getText();
        String email = text_player_level.getText();
        String class_id = text_national_id.getText();

        StudentRepository studentRepository = new StudentRepository();
        Player student = new Player();
        student.setPlayerId(0);
        student.setPlayerName(first_name);
        student.setPlayerLevel(Integer.parseInt(last_name));
        student.setPlayerHighScore(Integer.parseInt(email));
        student.setPlayerNationalId(Integer.parseInt(class_id));
        studentRepository.addPlayer(student);
        
    }

    @FXML
    private void addNational(){
        StudentRepository studentRepository = new StudentRepository();
        String national_name = text_national_name.getText();
        National national = new National();
        national.setNationalId(0);
        national.setNationalName(national_name);
        studentRepository.addNational(national);
    }

    @FXML
    private void switchTo_liststudent() throws IOException{
        App.setRoot("liststudent");
    }

    @FXML
    private void switchTo_deletestudent() throws IOException{
        App.setRoot("deletestudent");
    }

    @FXML
    private void switchTo_updatestudent() throws IOException{
        App.setRoot("updatestudent");
    }
}
