package com.example.entity;

public class Player {
    private Integer PlayerID;
    private String PlayerName;
    private Integer HighScore;
    private Integer Level;
    private Integer NationalId;

   
    
    public Integer getPlayerID() {
        return PlayerID;
    }
    public void setPlayerID(Integer playerID) {
        PlayerID = playerID;
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
    public void setHighScore(Integer integer) {
        HighScore = integer;
    }
    public Integer getLevel() {
        return Level;
    }
    public void setLevel(Integer level) {
        Level = level;
    }
    public Integer getNationalId() {
        return NationalId;
    }
    public void setNationalId(Integer nationalId) {
        NationalId = nationalId;
    }

}
