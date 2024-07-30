create table Player (
	PlayerID integer not null auto_increment,
    NationalID integer,
    PlayerName varchar(30),
    HighScore integer,
    PLevel integer,
    primary key (PlayerID)
    );
    
create table National (
	NationalID integer not null auto_increment,
    NationNames varchar(30),
    primary key (NationalID)
    );
    
alter table Player 
	add constraint Player_FK 
	foreign key (NationalID) 
	references National (NationalID);

    
    
