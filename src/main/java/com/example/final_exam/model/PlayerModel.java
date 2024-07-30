package com.example.final_exam.model;

public class PlayerModel {
    private Integer PlayerId;
    private Integer NationalId;
    private String PlayerName;
    private Integer HighScore;
    private Integer Level;

    public PlayerModel() {
    }

    public PlayerModel(Integer nationalId, String playerName, Integer highScore, Integer level) {
        NationalId = nationalId;
        PlayerName = playerName;
        HighScore = highScore;
        Level = level;
    }

    public Integer getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(Integer playerId) {
        PlayerId = playerId;
    }

    public Integer getNationalId() {
        return NationalId;
    }

    public void setNationalId(Integer nationalId) {
        NationalId = nationalId;
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
}
