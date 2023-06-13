# show variables like 'sql_mode';
# set sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

# set global log_bin_trust_function_creators = 1;
# set sql_safe_updates = 0;

# 1
create table countries
(
    id     int primary key auto_increment not null,
    `name` varchar(40) unique             not null
);

create table cities
(
    id         int primary key auto_increment not null,
    `name`     varchar(40) unique             not null,
    population int,
    country_id int                            not null,
    constraint fk_cities_countries
        foreign key (country_id)
            references countries (id)
);

create table universities
(
    id              int primary key auto_increment not null,
    `name`          varchar(60) unique             not null,
    address         varchar(80) unique             not null,
    tuition_fee     decimal(19, 2)                 not null,
    number_of_staff int,
    city_id         int,
    constraint fk_universities_cities
        foreign key (city_id)
            references cities (id)
);

create table students
(
    id           int primary key auto_increment not null,
    first_name   varchar(40)                    not null,
    last_name    varchar(40)                    not null,
    age          int,
    phone        varchar(20) unique             not null,
    email        varchar(255) unique            not null,
    is_graduated tinyint(1)                     not null,
    city_id      int,
    constraint fk_students_cities
        foreign key (city_id)
            references students (id)
);

create table courses
(
    id             int primary key auto_increment not null,
    `name`         varchar(40) unique             not null,
    duration_hours decimal(19, 2),
    start_date     date,
    teacher_name   varchar(60) unique             not null,
    description    text,
    university_id  int,
    constraint fk_courses_university
        foreign key (university_id)
            references universities (id)
);

create table students_courses
(
    grade      decimal(19, 2) not null,
    student_id int            not null,
    course_id  int            not null,
    constraint fk_students_courses_students
        foreign key (student_id)
            references students (id),
    constraint fk_students_courses_courses
        foreign key (course_id)
            references courses (id)
);

# 2
insert into courses(name, duration_hours, start_date, teacher_name, description, university_id)
select concat(c.teacher_name, ' course'),
       char_length(c.name) / 10,
       date(c.start_date + 5),
       reverse(c.teacher_name),
       concat('Course ', c.teacher_name, reverse(c.description)),
       day(c.start_date)
from courses as c
where c.id <= 5;

# 3
update universities
set tuition_fee = tuition_fee + 300
where id between 5 and 12;

# 4
delete u
from universities as u
where number_of_staff is null;

# 5
select id, name, population, country_id
from cities
order by population desc;

# 6
select first_name, last_name, age, phone, email
from students
where age >= 21
order by first_name desc, email, id
limit 10;

# 7
select concat_ws(' ', s.first_name, s.last_name) as full_name,
       substring(s.email, 2, 10)                 as username,
       reverse(s.phone)                          as password
from students as s
         left join students_courses sc on s.id = sc.student_id
where sc.course_id is null
order by password desc;

# 8
select count(sc.student_id) as students_count,
       u.name               as university_name
from students_courses as sc
         join courses c on sc.course_id = c.id
         join universities u on u.id = c.university_id
group by u.name
having students_count >= 8
order by students_count desc, university_name desc;

# 9
select u.name  as university_name,
       c.name  as city_name,
       u.address,
       case
           when u.tuition_fee < 800 then 'cheap'
           when u.tuition_fee >= 800 and u.tuition_fee < 1200 then 'normal'
           when u.tuition_fee >= 1200 and u.tuition_fee < 2500 then 'high'
           else 'expensive'
           end as price_rank,
       u.tuition_fee
from universities as u
         join cities c on c.id = u.city_id
order by u.tuition_fee;

# 10
delimiter //
create function udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
    returns decimal(19, 2)
    deterministic
begin
    return (select avg(sc.grade)
            from students_courses as sc
                     join students s on s.id = sc.student_id
                     join courses c on sc.course_id = c.id
            where c.name = course_name
              and s.is_graduated = 1
            group by c.name);
end //
delimiter ;

SELECT c.name, udf_average_alumni_grade_by_course_name('Quantum Physics') as average_alumni_grade
FROM courses c
WHERE c.name = 'Quantum Physics';

# 11
delimiter //
create procedure udp_graduate_all_students_by_year(year_started INT)
begin
update students as s
    join students_courses sc on s.id = sc.student_id
    join courses c on sc.course_id = c.id
set s.is_graduated = 1
    where year(c.start_date) = year_started;
end //
delimiter ;

select s.is_graduated
from courses as c
join students_courses sc on c.id = sc.course_id
join students s on sc.student_id = s.id
where year(c.start_date) = 2017;

CALL udp_graduate_all_students_by_year(2017);

select extract(day from start_date),day(start_date), locate('a', courses.name, 1) from courses