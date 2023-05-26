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
alter table minions 
drop constraint fk_minions_towns; 
drop table towns;

-- 6
CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(10 , 2 ),
    weight DOUBLE(10 , 2 ),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

insert into people (name, gender, birthdate) 
values
('Nikolay', 'm', DATE(NOW())),
('Elica', 'f', DATE(NOW())),
('Nikolay', 'm', DATE(NOW())),
('Ivaila', 'f', DATE(NOW())),
('Nikolay', 'm', DATE(NOW()));


-- 7

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time DATETIME,
    is_deleted BOOLEAN
); 

insert into users(username, password)
values
('test', 'testPass'),
('test', 'testPass'),
('test', 'testPass'),
('test', 'testPass'),
('test', 'testPass');

-- 8
ALTER TABLE users
DROP PRIMARY KEY ,
ADD CONSTRAINT pk_users2
PRIMARY KEY users(id, username);

-- 9
ALTER TABLE users
CHANGE COLUMN last_login_time last_login_time 
DATETIME DEFAULT NOW();

-- 10
ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users 
PRIMARY KEY users(id),
CHANGE COLUMN username
username VARCHAR(30) UNIQUE;

-- 11
CREATE DATABASE movies;
USE MOVIES;
CREATE TABLE directors(
id INT PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(50) NOT NULL,
notes TEXT
);

INSERT INTO directors (director_name)
VALUES
('Test Director'),
('Test Director'),
('Test Director'),
('Test Director'),
('Test Director');

CREATE TABLE geners (
    id INT PRIMARY KEY AUTO_INCREMENT,
    gener_name VARCHAR(50) NOT NULL,
    notes TEXT
);

INSERT INTO geners (gener_name)
VALUES
('Test Gener'),
('Test Gener'),
('Test Gener'),
('Test Gener'),
('Test Gener');

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(50) NOT NULL,
notes TEXT
);

INSERT INTO categories(category_name)
VALUES
('Test Category'),
('Test Category'),
('Test Category'),
('Test Category'),
('Test Category');

CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    director_id INT,
    copyright_year YEAR,
    length DOUBLE(10 , 2 ),
    gener_id INT,
    category_id INT,
    rating DOUBLE(3 , 2 ),
    notes TEXT,
    FOREIGN KEY (director_id)
        REFERENCES directors (id),
    FOREIGN KEY (gener_id)
        REFERENCES geners (id),
    FOREIGN KEY (category_id)
        REFERENCES categories (id)
);
INSERT INTO movies(title, director_id, gener_id, category_id)
VALUES
('Test Movie', 1, 2, 3),
('Test Movie', 1, 2, 3),
('Test Movie', 1, 2, 3),
('Test Movie', 1, 2, 3),
('Test Movie', 1, 2, 3);

-- 12
CREATE DATABASE car_rental;
use car_rental;

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT, 
category VARCHAR(30) NOT NULL, 
daily_rate INT, 
weekly_rate DOUBLE(3,2), 
monthly_rate DOUBLE(3,2), 
weekend_rate DOUBLE (3,2)
);

INSERT INTO categories(category) values("sedan"),("pickup"),("moster truck");

CREATE TABLE cars 
(id INT PRIMARY KEY AUTO_INCREMENT, 
plate_number VARCHAR(10) NOT NULL, 
make VARCHAR(20), 
model VARCHAR(20), 
car_year INT, 
category_id INT NOT NULL, 
doors INT, 
picture BLOB, 
car_condition VARCHAR(20), 
available BOOLEAN 
);

INSERT INTO cars (plate_number, category_id)
VALUES
("CA7610HA", 2),
("PB2412KA", 3),
("A4664TT", 1);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT, 
first_name VARCHAR(20) NOT NULL, 
last_name VARCHAR(20), 
title VARCHAR(20), 
notes TEXT
);
INSERT INTO employees (first_name) VALUES("Nikolay"),("Elica"),("Ivaila");

CREATE TABLE customers 
(id INT PRIMARY KEY AUTO_INCREMENT, 
driver_licence_number VARCHAR(20) NOT NULL, 
full_name VARCHAR(30), 
address VARCHAR(30), 
city VARCHAR (30), 
zip_code INT, 
notes TEXT
);
INSERT INTO customers (driver_licence_number) VALUES ('63574B'), ('4564A55'), ('64163AB');

CREATE TABLE rental_orders (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(20),
    tank_level VARCHAR(10),
    kilometrage_start DOUBLE(10 , 2 ),
    kilometrage_end DOUBLE(10 , 2 ),
    total_kilometrage DOUBLE(10 , 2 ),
    start_date DATETIME DEFAULT NOW(),
    end_date DATETIME DEFAULT NOW(),
    total_days INT,
    rate_applied DOUBLE(10 , 2 ),
    tax_rate DOUBLE(10 , 2 ),
    order_status VARCHAR(10),
    notes TEXT
);

INSERT INTO rental_orders (employee_id, customer_id, car_id)
VALUES(1, 2 , 3),
(3, 2 , 1),
(1, 1, 1);






-- 13
CREATE TABLE towns(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30)
);

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT,
address_text VARCHAR(50),
town_id INT
);

CREATE TABLE departments(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30)
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    middle_name VARCHAR(30),
    last_name VARCHAR(30),
    job_title VARCHAR(30),
    department_id INT,
    hire_date DATE DEFAULT NOW(),
    salary DOUBLE(10 , 2 ),
    address_id INT,
    FOREIGN KEY (department_id)
    REFERENCES departments(id),
    FOREIGN KEY (address_id)
    REFERENCES addresses(id)
);

INSERT INTO towns(name)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments(name)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees(first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, DATE('2013-03-02'),3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, DATE('2004-03-02'), 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, DATE ('2016-08-28'), 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, DATE ('2007-12-09'),3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, DATE('2016-08-28'),599.88);

-- 14/15
SELECT * FROM towns as t ORDER BY t.name;
SELECT * FROM departments as d ORDER BY d.name;
SELECT * FROM employees as e ORDER BY e.salary DESC; 

-- 16
SELECT 
    t.name
FROM
    towns AS t
ORDER BY t.name;
SELECT 
    d.name
FROM
    departments AS d
ORDER BY d.name;
SELECT 
    e.first_name, e.last_name, e.job_title, e.salary
FROM
    employees AS e
ORDER BY e.salary DESC; 

-- 17
UPDATE employees
SET salary = salary * 1.10 
WHERE id > 0;
SELECT salary FROM employees;



