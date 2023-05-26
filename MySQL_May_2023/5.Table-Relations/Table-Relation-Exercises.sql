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
    salary      decimal(10, 2),
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
            references passports (passport_id);

insert into passports (passport_id, passport_number)
values (101, 'N34FG21B'),
       (102, 'K65LO4R7'),
       (103, 'ZE657QP2');

insert into people (first_name, salary, passport_id)
values ('Roberto', 43300.00, 102),
       ('Tom', 56100.00, 103),
       ('Yana', 60200.00, 101);

# 2
create table manufacturers
(
    manufacturer_id int auto_increment not null primary key,
    name            varchar(30),
    established_on  date
);

create table models
(
    model_id        int auto_increment not null primary key,
    name            varchar(30),
    manufacturer_id int,
    constraint fk__models_manufacturer_id__manufacturers_manufacturer_id
        foreign key (manufacturer_id)
            references manufacturers (manufacturer_id)

);

insert into manufacturers(name, established_on)
VALUES ('BMW', '1916/03/01'),
       ('Tesla', '2003/01/01'),
       ('Lada', '1966/05/01');

insert into models (model_id, name, manufacturer_id)
values (101, 'X1', 1),
       (102, 'i6', 1),
       (103, 'Model S', 2),
       (104, 'Model X', 2),
       (105, 'Model 3', 2),
       (106, 'Nova', 3);

# 3
create table students
(
    student_id int auto_increment not null primary key,
    name       varchar(30)
);

create table exams
(
    exam_id int auto_increment not null primary key,
    name    varchar(30)
);

create table students_exams
(
    student_id int not null,
    exam_id    int not null,
    constraint pk__students_student_id__exams_exams_id
        primary key (student_id, exam_id)
);

alter table students_exams
    add constraint fk__students_exams_student_id__students_students_id
        foreign key (student_id)
            references students (student_id);

alter table students_exams
    add constraint fk__students_exams_exam_id__exams_exam_id
        foreign key (exam_id)
            references exams (exam_id);

insert into students(name)
VALUES ('Mila'),
       ('Toni'),
       ('Ron');

insert into exams (exam_id, name)
VALUES (101, 'Spring MVC'),
       (102, 'Neo4j'),
       (103, 'Oracle 11g');

insert into students_exams (student_id, exam_id)
VALUES (1, 101),
       (1, 102),
       (2, 101),
       (3, 103),
       (2, 102),
       (2, 103);

