# 9
select mountain_range, peak_name, elevation as peak_elevetion
from mountains as m
         join peaks on peaks.mountain_id = m.id
where m.mountain_range = 'Rila'
order by peak_elevetion desc;

create database table_relations_exercises;
use table_relations_exercises;
# 1
create table people
(
    person_id   int auto_increment not null unique,
    first_name  varchar(50),
    salary      decimal (10, 2),
    passport_id int unique
);

create table passports
(
    passport_id     int auto_increment not null primary key,
    passport_number varchar(30) unique
);

alter table people
add constraint pk__people_person_id
primary key (person_id);

alter table people
add constraint fk__people_passport_id__passports_passport_id
foreign key (passport_id)
references passports(passport_id);

insert into passports (passport_id, passport_number)
values (101, 'N34FG21B'),
       (102, 'K65LO4R7'),
       (103, 'ZE657QP2');

insert into people (first_name, salary, passport_id)
values ('Roberto', 43300.00, 102),
       ('Tom', 56100.00, 103),
       ('Yana', 60200.00, 101);


