package com.example.finaltest.Entity;

public class Player {
    String PlayerName;
    Integer HighScore;
    Integer Level;
    Integer NationalID;

    public Player(String playerName, Integer highScore, Integer level, Integer nationalID) {
        PlayerName = playerName;
        HighScore = highScore;
        Level = level;
        NationalID = nationalID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public Integer getHighScore() {
        return HighScore;
    }

    public void setHighScore(Integer highScore) {
        HighScore = highScore;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

    public Integer getNationalID() {
        return NationalID;
    }

    public void setNationalID(Integer nationalID) {
        NationalID = nationalID;
    }
}
