package com.example.entity;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player {
    private final IntegerProperty playerId;
    private final StringProperty playerName;
    private final IntegerProperty highScore;
    private final IntegerProperty level;
    private final StringProperty national;

    public Player(int playerId, String playerName, int highScore, int level, String national) {
        this.playerId = new SimpleIntegerProperty(playerId);
        this.playerName = new SimpleStringProperty(playerName);
        this.highScore = new SimpleIntegerProperty(highScore);
        this.level = new SimpleIntegerProperty(level);
        this.national = new SimpleStringProperty(national);
    }

    public int getPlayerId() {
        return playerId.get();
    }

    public void setPlayerId(int playerId) {
        this.playerId.set(playerId);
    }

    public IntegerProperty playerIdProperty() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName.get();
    }

    public void setPlayerName(String playerName) {
        this.playerName.set(playerName);
    }

    public StringProperty playerNameProperty() {
        return playerName;
    }

    public int getHighScore() {
        return highScore.get();
    }

    public void setHighScore(int highScore) {
        this.highScore.set(highScore);
    }

    public IntegerProperty highScoreProperty() {
        return highScore;
    }

    public int getLevel() {
        return level.get();
    }

    public void setLevel(int level) {
        this.level.set(level);
    }

    public IntegerProperty levelProperty() {
        return level;
    }

    public String getNational() {
        return national.get();
    }

    public void setNational(String national) {
        this.national.set(national);
    }

    public StringProperty nationalProperty() {
        return national;
    }
}
