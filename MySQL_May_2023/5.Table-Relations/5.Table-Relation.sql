# 1
create database mountains;
use mountains;

create table mountains
(
    id     int auto_increment not null,
    `name` varchar(100)       not null,
    constraint pk_mountains_id PRIMARY KEY (id)
);

insert into mountains(name)
values ('Rila'),
       ('Pirin');

create table peaks
(
    id          int auto_increment not null PRIMARY KEY,
    `name`      varchar(100)       not null,
    mountain_id int                not null,
    constraint fk_peaks_mountains_id_mountains_id foreign key (mountain_id)
        references mountains (id)
);

insert into peaks (name, mountain_id)
values ('Musala', 1),
       ('Vihren', 2);

select mountains.name, p.name
from mountains
         join peaks p on p.mountain_id = mountains.id;

# 2
select v.driver_id, v.vehicle_type, concat_ws(' ', c.first_name, c.last_name) as driver_name
from campers as c
         join vehicles as v on v.driver_id = c.id;

# 2-1
select v.driver_id, v.vehicle_type, concat(c.first_name, ' ', c.last_name)
from vehicles as v
         join campers as c on driver_id = c.id;

drop table peaks;
drop table mountains;
use mountains;

# 3
use camp;
select starting_point, end_point, leader_id, concat(c.first_name, ' ', c.last_name) as `leader_name`,c.id
from routes as r
         join campers c on c.id = r.leader_id;

# 4

create table mountains
(
    id     int auto_increment not null,
    `name` varchar(100)       not null,
    constraint pk_mountains_id PRIMARY KEY (id)
);


create table peaks
(
    id          int auto_increment not null PRIMARY KEY,
    `name`      varchar(100)       not null,
    mountain_id int                not null,
    constraint fk_peaks_mountains_id_mountains_id foreign key (mountain_id)
        references mountains (id)
        on delete cascade
);

insert into mountains(name)
values ('Rila'),
       ('Pirin');

insert into peaks (name, mountain_id)
values ('Vihren 1', 2),
       ('Vihren 2', 2),
       ('Vihren 3', 2);

delete
from peaks
where id = 3;
delete
from mountains
where id = 2;

# 5
create database project_management;
use project_management;

create table clients
(
    id          int auto_increment not null primary key,
    client_name varchar(100)
);

create table projects
(
    id              int auto_increment not null primary key,
    client_id       int,
    project_lead_id int,
    constraint fk_projects_client_id_clients_id foreign key (client_id) references clients (id)

);

create table employees
(
    id         int auto_increment not null primary key,
    first_name varchar(30),
    last_name  varchar(30),
    project_id int,
    constraint fk__employees_project_id__projects_id foreign key
        (project_id) references projects (id)


);

alter table projects
    add constraint foreign key fk__projects_project_lead_id__employees_id
        (project_lead_id) references employees (id);