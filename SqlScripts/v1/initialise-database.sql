drop database CetDecoded;
create database CetDecoded;
use CetDecoded;

------------------------------------------------------------------------------------------------------------------------
-- CREATE TABLES
------------------------------------------------------------------------------------------------------------------------

create table User
(
	id int auto_increment primary key,
    user_name varchar(20) not null,
    password varchar(20) not null
);

create table Section
(
	id int auto_increment primary key,
    section_name varchar(15) not null
);

create table Subsection
(
	id int auto_increment primary key,
    subsection_name varchar(50) not null,
    parent_section_id int not null,
    foreign key fk_parent_section_id(parent_section_id)
    references Section(id)
);

create table Label
(
	id int auto_increment primary key,
    label_name varchar(20) not null
);

create table Prose
(
	id int auto_increment primary key,
    prose_body varchar(4000) not null
);

create table Question
(
	id int auto_increment primary key,
    statement varchar(500) not null,
    prose_id int,
    type int not null default 0,
    options varchar(1000),
    answer varchar(6) not null,
    subsection_id int not null,
    exercise_number int,
    expected_time_to_answer int not null,
    solution varchar(3000) default null,
    foreign key fk_subsection_id(subsection_id)
    references Subsection(id),
    foreign key fk_prose_id(prose_id)
    references Prose(id)
);

------------------------------------------------------------------------------------------------------------------------
-- LOAD DATA FROM CSV FILES
------------------------------------------------------------------------------------------------------------------------

LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/User.csv' 
INTO TABLE User
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/Section.csv' 
INTO TABLE Section
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/Subsection.csv' 
INTO TABLE Subsection
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/Prose.csv' 
INTO TABLE Prose
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

LOAD DATA LOCAL INFILE '/home/lightt77/abhishek/coding/open source/myprojects/cet-decoded/SqlScripts/v1/csvs/Question.csv' 
INTO TABLE Question
FIELDS TERMINATED BY ',' 
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;

------------------------------------------------------------------------------------------------------------------------
-- STORED PROCS
------------------------------------------------------------------------------------------------------------------------
 
DELIMITER $$
create procedure GET_ALL_SECTIONS()
begin
	select * from Section;
end$$
DELIMITER ;

DELIMITER $$
create procedure GET_SUBSECTIONS_FOR_SECTION(in p_section_name varchar(15))
begin
	select * from Subsection where parent_section_id = (Select id from Section where section_name = p_section_name);
end$$
DELIMITER ;