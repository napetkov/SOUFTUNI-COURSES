CREATE DATABASE gamebar;
CREATE TABLE employees(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL
);
CREATE TABLE categories(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL
);
CREATE TABLE products(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
category_id INT NOT NULL,
FOREIGN KEY (category_id) REFERENCES employees(id)
);

INSERT INTO employees (id, first_name, last_name)
VALUES 	(1, 'Nikolay', "Petkov"),
		(2, "Georgi", "Georgiev"),
		(3, "Ivan", "Ivanov");
ALTER TABLE employees ADD COLUMN middle_name VARCHAR(50) NOT NULL;
-- ALTER TABLE products ADD CONSTRAINT fk_child_parent
-- FOREIGN KEY (category_id) REFERENCES employees(id);
ALTER TABLE employees
MODIFY COLUMN middle_name VARCHAR(100);

