package com.example.finaltest.Entity;

public class PlayerList {
    String PlayerName;
    Integer HighScore;
    Integer Level;
    String National;

    public String getNational() {
        return National;
    }

    public void setNational(String national) {
        National = national;
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
