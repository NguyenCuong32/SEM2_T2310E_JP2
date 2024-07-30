package com.example.Entity;

public class Player {
    private Integer player_id;
    private Integer national_id;
    private String player_name;
    private Integer highscore;
    private Integer level;

    public Player(Integer national_id, String player_name, Integer highscore, Integer level) {
        this.national_id = national_id;
        this.player_name = player_name;
        this.highscore = highscore;
        this.level = level;
    }

    public Player(Integer player_id, Integer national_id, String player_name, Integer highscore, Integer level) {
        this.player_id = player_id;
        this.national_id = national_id;
        this.player_name = player_name;
        this.highscore = highscore;
        this.level = level;
    }

    public Player() {
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getNational_id() {
        return national_id;
    }

    public void setNational_id(Integer national_id) {
        this.national_id = national_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}