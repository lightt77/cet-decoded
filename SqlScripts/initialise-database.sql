--
create database CetDecoded;
use CetDecoded;

----------------------------------------------------------------------------------------

create table User
(
	id INT primary key auto_increment not null,
    email_id varchar(50) unique not null,
    password varchar(50) not null,
    role int default 0
);

create table Question
(
	id int auto_increment primary key,
    statement varchar(1000) not null,
    type int not null default 0,
    options varchar(1000),
    answer varchar(6) not null,
    section varchar(20) not null,
    expected_time_to_answer int not null,
    solution varchar(3000) default null
);

create table Question_Set
(
	id int auto_increment primary key,
    title varchar(20) not null
);

create table Question_set_Question
(
	question_set_id int,
    question_id int,
    foreign key fk_question_set_id(question_set_id)
    references Question_Set(id),
    foreign key fk_question_id(question_id)
    references Question(id)
);

----------------------------------------------------------------------------------------

insert into user(email_id, password, role) values('abhishek@pqr.com', 'pqrs', 1);
insert into user(email_id, password, role) values('vinay@pqr.com', 'pqrs', 1);
insert into user(email_id, password, role) values('aditya@pqr.com', 'pqrs', 1);
insert into user(email_id, password) values('user1@pqr.com', 'pqrs');
insert into user(email_id, password) values('user2@pqr.com', 'pqrs');
insert into user(email_id, password) values('user3@pqr.com', 'pqrs');
insert into user(email_id, password) values('user4@pqr.com', 'pqrs');

----------------------------------------------------------------------------------------

-- stored procs

-- gets user using his email id
DELIMITER $$
create procedure GET_USER(in p_email_id varchar(50))
begin
	Select * from User where email_id=p_email_id;
end$$
DELIMITER ;

Call GET_USER('abhishek@pqr.com');