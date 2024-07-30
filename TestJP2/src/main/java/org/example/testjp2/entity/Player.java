package org.example.testjp2.entity;

public class Player {
    private Integer PlayerID;
    private Integer NationalID;
    private String PlayerName;
    private Integer HighScore;
    private Integer Plevel;

    public  Player(Integer NationalID, String PlayerName, Integer HighScore, Integer Plevel) {
        this.NationalID = NationalID;
        this.PlayerName = PlayerName;
        this.HighScore = HighScore;
        this.Plevel = Plevel;
    }

    public  Player() {

    }
    public Integer getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(Integer playerID) {
        PlayerID = playerID;
    }

    public Integer getNationalID() {
        return NationalID;
    }

    public void setNationalID(Integer nationalID) {
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

    public Integer getPlevel() {
        return Plevel;
    }

    public void setPlevel(Integer plevel) {
        Plevel = plevel;
    }

}
