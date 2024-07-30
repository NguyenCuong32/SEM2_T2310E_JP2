package com.example.javafx30072024.dto;

public class PlayerDTO {
    private Long playerId;
    private String playerName;
    private String highScore;
    private String level;
    private String nationalName;

    public PlayerDTO() {
    }

    public PlayerDTO(Long playerId, String playerName, String highScore, String level, String nationalName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.nationalName = nationalName;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
