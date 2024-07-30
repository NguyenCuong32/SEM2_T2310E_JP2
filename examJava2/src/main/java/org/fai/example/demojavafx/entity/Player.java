package org.fai.example.demojavafx.entity;

public class Player {
    private Integer playerId;
    private String playerName;
    private Integer highScore;
    private Integer level;
    private Integer nationalId;

    // Constructor matching the parameters in the findAll method
    public Player(Integer playerId, String playerName, Integer highScore, Integer level, Integer nationalId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.nationalId = nationalId;
    }

    // Default constructor
    public Player() {}

    // Getters and setters
    public Integer getPlayerId() { return playerId; }
    public void setPlayerId(Integer playerId) { this.playerId = playerId; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public Integer getHighScore() { return highScore; }
    public void setHighScore(Integer highScore) { this.highScore = highScore; }
    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
    public Integer getNationalId() { return nationalId; }
    public void setNationalId(Integer nationalId) { this.nationalId = nationalId; }
}
