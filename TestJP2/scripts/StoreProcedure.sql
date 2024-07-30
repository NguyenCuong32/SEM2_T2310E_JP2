USE `testproject`;INSERT_STUDENT

delimiter //
drop procedure IF EXISTS INSERT_PLAYER;
create
definer = root@`%` procedure INSERT_PLAYER(IN NationalID int, IN PlayerName varchar(30), IN HighScore int,
                                              IN PLevel int  )
BEGIN
insert into player(NationalID, PlayerName, HighScore, PLevel ) VALUES (NationalID, PlayerName, HighScore, PLevel);
end;

create
definer = root@`%` procedure DELETE_PLAYER(IN PlayerId int)
BEGIN
delete from player A where id = PlayerId;
end;

create
definer = root@`%` procedure INSERT_NATIONAL(IN PlayerName varchar(30))
BEGIN
insert into national(NationNames) VALUES (NationNames);
end;

create
definer = root@`%` procedure DELETE_NATIONAL(IN NationalId int)
BEGIN
delete from national A where id = NationalId;
end;
//
delimiter ;
