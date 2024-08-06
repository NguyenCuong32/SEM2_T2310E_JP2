CREATE DATABASE HeroGame;
USE HeroGame;
CREATE TABLE National (
    NationalId INT AUTO_INCREMENT PRIMARY KEY,
    NationalName VARCHAR(100) NOT NULL
);

CREATE TABLE Player (
    PlayerId INT AUTO_INCREMENT PRIMARY KEY,
    NationalId INT,
    PlayerName VARCHAR(100) NOT NULL,
    HighScore INT NOT NULL,
    Level INT NOT NULL,
    FOREIGN KEY (NationalId) REFERENCES National(NationalId)
);
