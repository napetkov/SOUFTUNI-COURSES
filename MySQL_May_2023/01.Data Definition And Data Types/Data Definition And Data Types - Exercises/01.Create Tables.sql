CREATE DATABASE minions;
use minions;
-- 1 
CREATE TABLE minions(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
age INT NOT NULL
);

CREATE TABLE towns(
town_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL
);

-- 2
alter table minions add column town_id int;
alter table minions
add constraint fk_minions_towns
foreign key minions(town_id)
references towns(id);

-- 3
insert into towns(id, name) values
(1, 'Sofia'), 
(2, 'Plovdiv'), 
(3, 'Varna'); 

insert into minions(id, name, age, town_id) values 
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);

-- 4
truncate table minions;

-- 5
drop table minions;
drop table towns;

