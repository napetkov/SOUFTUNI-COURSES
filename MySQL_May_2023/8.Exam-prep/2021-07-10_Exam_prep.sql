show variables like 'sql_mode';
set sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

# 1
create table addresses
(
    id     int primary key auto_increment not null,
    `name` varchar(100)                   not null
);

create table categories
(
    id     int primary key auto_increment not null,
    `name` varchar(10)                    not null
);

create table clients
(
    id           int primary key auto_increment not null,
    full_name    varchar(50)                    not null,
    phone_number varchar(20)                    not null
);

create table drivers
(
    id         int primary key auto_increment not null,
    first_name varchar(30)                    not null,
    last_name  varchar(30)                    not null,
    age        int                            not null,
    rating     float default 5.5
);

create table cars
(
    id          int primary key auto_increment not null,
    make        varchar(20)                    not null,
    model       varchar(20),
    year        int default 0                  not null,
    mileage     int default 0,
    `condition` char(1)                        not null,
    category_id int                            not null,
    constraint fk_cars_categories
        foreign key (category_id)
            references categories (id)
);

create table courses
(
    id              int primary key auto_increment not null,
    from_address_id int                            not null,
    start           datetime                       not null,
    bill            decimal(10, 2) default 10,
    car_id          int                            not null,
    client_id       int                            not null,
    constraint fk_courses_address
        foreign key (from_address_id)
            references addresses (id),
    constraint fk_curses_cars
        foreign key (car_id)
            references cars (id),
    constraint fk_courses_clients
        foreign key (client_id)
            references clients (id)
);

create table cars_drivers
(
    car_id    int not null,
    driver_id int not null,
    constraint pk_cars_drivers primary key (car_id, driver_id),
    constraint fk_cars_drivers_cars
        foreign key (car_id)
            references cars (id),
    constraint fk_cars_drivers_drivers
        foreign key (driver_id)
            references drivers (id)
);

# 2
insert into clients(full_name, phone_number)
select concat_ws(' ', first_name, last_name) as full_name, concat('(088) 9999', (drivers.id * 2)) as phone_number
from drivers
where drivers.id between 10 and 20;

# 3
update cars as c
set c.`condition` = 'C'
where (c.mileage >= 800000 or c.mileage is null)
  and c.year <= 2010
  and c.make != 'Mercedes-Benz';

# 4
delete c
from clients as c
         left join courses c2 on c.id = c2.client_id
where c2.car_id is null
  and char_length(c.full_name) > 3;

# 5
select make, model, `condition`
from cars
order by id;

# 6
select first_name, last_name, c.make, c.model, c.mileage
from drivers as d
         join cars_drivers cd on d.id = cd.driver_id
         join cars c on c.id = cd.car_id
where c.mileage is not null
order by mileage desc, first_name;

# 7
select c.id                   as car_id,
       c.make                 as make,
       c.mileage              as mieage,
       count(c2.id)           as count_of_courses,
       round(avg(c2.bill), 2) as avg_bill
from cars as c
         left join courses c2 on c.id = c2.car_id
group by c.id
having count_of_courses != 2
order by count_of_courses desc, c.id;

# 8
select c.full_name,
       count(c3.id) as count_of_carts,
       sum(c2.bill) as total_sum
from clients as c
         join courses c2 on c.id = c2.client_id
         join cars c3 on c3.id = c2.car_id
where substring(full_name, 2, 1) = 'a'
group by c.full_name
having COUNT_OF_CARTS > 1
order by full_name;

# 9
select a.name,
       case
           when hour(c.start) between 6 and 20 then 'Day'
           when hour(c.start) < 6 or hour(c.start) > 20 then 'Night'
           end as day_time,
       c.bill,
       c2.full_name,
       c3.make,
       c3.model,
       c4.name as category_name
from courses as c
         join addresses a on a.id = c.from_address_id
         join clients c2 on c.client_id = c2.id
         join cars c3 on c3.id = c.car_id
         join categories c4 on c4.id = c3.category_id
order by c.id;

# 10
delimiter //
create function udf_courses_by_client(phone_num VARCHAR(20))
    returns int
    deterministic
begin
    return (select count(c.id)
            from courses as c
                     join clients c2 on c2.id = c.client_id
            where c2.phone_number = phone_num
            group by (c2.id));
end //
delimiter ;

select count(c.id)
from courses as c
         join clients c2 on c2.id = c.client_id
where c2.phone_number = '(803) 6386812'
group by (c2.id);

# 11
delimiter //
create procedure udp_courses_by_address(`address_name` varchar(100))
begin
    select a.name   as name,
           cl.full_name,
           case
               when c.bill <= 20 then 'Low'
               when c.bill > 20 and c.bill <= 30 then 'Medium'
               else 'High'
               end
                    as level_of_bill,
           cars.make,
           cars.`condition`,
           cat.name as cat_name
    from addresses as a
             join courses c on a.id = c.from_address_id
             join clients cl on c.client_id = cl.id
             join cars on cars.id = c.car_id
             join categories cat on cars.category_id = cat.id
    where a.name = `address_name`
    order by cars.make, cl.full_name;
end //
delimiter ;

