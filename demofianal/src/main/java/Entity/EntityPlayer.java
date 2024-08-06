package Entity;

public class EntityPlayer {
    private int playerId;
    private String playerName;
    private int highScore;
    private int level;
    private String nationalName;


    public EntityPlayer(int playerId, String playerName, int highScore, int level, String nationalName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.highScore = highScore;
        this.level = level;
        this.nationalName = nationalName;
    }


    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
