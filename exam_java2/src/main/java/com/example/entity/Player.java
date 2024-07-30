package com.example.entity;

public class Player {
    private int playerID ;
    private int nationalID ;
    private String playerName;
    private int highScore;
    private int level;
    public int getPlayerID() {
        return playerID;
    }
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
    public int getNationalID() {
        return nationalID;
    }
    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getHighScore() {
        return highScore;
    }
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Player(int playerID, int nationalID, String playerName, int highScore, int level) {
        this.playerID = playerID;
        this.nationalID = nationalID;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
    }
    
    

    
}
