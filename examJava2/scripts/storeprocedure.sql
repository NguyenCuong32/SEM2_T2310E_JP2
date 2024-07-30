create
definer = root@`%` procedure DELETE_STUDENT(IN studentId int)
BEGIN
delete from student A where id = studentId;
end;

create
definer = root@`%` procedure INSERT_CLASSROOM(IN class_name varchar(30), IN number_member int)
BEGIN
INSERT INTO class_room(class_name, number_member) values (class_name,number_member);
end;

create
definer = root@`%` procedure INSERT_STUDENT(IN email varchar(64), IN first_name varchar(255), IN id_class int,
                                                IN last_name varchar(255))
BEGIN
insert into student(email, first_name, id_class, last_name) VALUES (email,first_name,id_class,last_name);
end;

create
definer = root@`%` procedure SELECT_CLASSROOM()
BEGIN
select class_room.class_name,class_room.number_member from class_room;-- Nen
end;

create
definer = root@`%` procedure SELECT_STUDENT_BYID(IN studentId int)
BEGIN
select  A.first_name,
        A.last_name,
        A.id_class,
        A.email
from student A where id = studentId;
end;

create
definer = root@`%` procedure UPDATE_STUDENT(IN first_name varchar(255), IN last_name varchar(255),
                                                IN email varchar(64), IN id_class int, IN student_id int)
BEGIN
update student set first_name=first_name,
                   last_name = last_name,
                   email = email,
                   id_class =id_class
where id =student_id;
end;

drop procedure if exists SP_GET_ALL_STUDENTS;
create procedure SP_GET_ALL_STUDENTS()
begin
select id,first_name,last_name,cr.class_name from 03_university.student left join
                                                  `03_university`.class_room
                                                      cr on student.id_class = cr.id_class;
end;
CALL SP_GET_ALL_STUDENTS