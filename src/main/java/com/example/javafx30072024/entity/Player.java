package com.example.javafx30072024.entity;

public class Player {
    private Long playerId;
    private String playerName;
    private String highScore;
    private String level;
    private Long nationalId;

    public Player() {
    }

    public Player(Long playerId, String playerName, String highScore, String level, Long nationalId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.nationalId = nationalId;
    }

    public Player(String playerName, String highScore, String level, Long nationalId) {
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.nationalId = nationalId;
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

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }
}
