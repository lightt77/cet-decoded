use CetDecoded;

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

insert into User(user_name, password)
values('vinay.chavhan', 'vapadav');
insert into User(user_name, password)
values('aditya', 'vapadav');
insert into User(user_name, password)
values('abhishek', 'vapadav');

select * from User;

insert into Section(section_name)
values('Quants');
insert into Section(section_name)
values('LR');
insert into Section(section_name)
values('Vocab');

select * from Section;