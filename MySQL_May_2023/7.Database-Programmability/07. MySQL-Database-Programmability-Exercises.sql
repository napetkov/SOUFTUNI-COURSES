# 1
delimiter $$
create procedure usp_get_employees_salary_above_35000()
begin
    select first_name, last_name
    from employees
    where salary > 35000
    order by first_name, last_name;
end $$
delimiter ;
;

# 2
delimiter $$
create procedure usp_get_employees_salary_above(min_salary decimal(9, 4))
begin
    select first_name,last_name from employees
    where salary >= min_salary
    order by first_name,last_name,employee_id asc;
end $$
delimiter ;
;

# 3
