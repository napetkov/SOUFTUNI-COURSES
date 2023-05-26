-- 1
SELECT 
id AS 'ID', 
concat (first_name, ' ', last_name)  AS 'Full name',
job_title AS 'Job title' 
FROM employees ORDER BY (id);

-- 2
SELECT 
id,
concat_ws(' ', first_name, last_name) AS 'full_name',
job_title,
salary
FROM employees
WHERE salary > 1000.00
ORDER BY id;

SELECT DISTINCT id, first_name, last_name,department_id 
FROM employees
WHERE ( NOT department_id = 1) AND first_name = 'John';


SELECT DISTINCT id, first_name, last_name,department_id 
FROM employees
WHERE id BETWEEN 1 AND 5;

SELECT DISTINCT id, first_name, last_name,department_id 
FROM employees
WHERE department_id NOT IN (1 , 8 , 9);

SELECT * FROM employees
WHERE department_id = 4 and salary >= 1000
ORDER BY id ASC;


SELECT * 
FROM employees
ORDER BY salary DESC
;

CREATE VIEW v_top_paied_employee AS
SELECT * 
FROM employees
ORDER BY salary DESC
;


SELECT * FROM v_top_paied_employee;

-- 3
UPDATE employees
SET salary = salary + 100
WHERE job_title = 'Manager';
SELECT salary 
FROM employees
;

-- 4
USE hotel;
SELECT  * FROM employees
ORDER BY salary DESC
LIMIT 1;

-- 5
SELECT * from employees
WHERE department_id = 4 AND salary >= 1000
ORDER BY id;

-- 6

DELETE FROM employees
WHERE department_id = 1 OR department_id = 2; 
SELECT * FROM employees 
ORDER BY id;