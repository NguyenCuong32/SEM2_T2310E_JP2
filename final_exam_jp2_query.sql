create database HeroGame;
use HeroGame;

create table National(
    NationalId int primary key auto_increment,
    NationalName varchar(255)
);

create table Player
(
    PlayerId    int auto_increment,
    NationalId  int,
    PlayerName varchar(255),
    HighScore   int,
    Level int,
    PRIMARY KEY (PlayerId, NationalId),
    FOREIGN KEY (NationalId) REFERENCES National(NationalId)
);