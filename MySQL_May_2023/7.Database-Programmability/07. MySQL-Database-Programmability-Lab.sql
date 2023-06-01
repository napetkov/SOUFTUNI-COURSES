delimiter $$
create function ufn_select_5()
    returns int
    deterministic
begin
    return (select 5);
end$$
delimiter ;
;


# 1 Functions
delimiter $$
create function ufn_count_employees_by_town(town_name varchar(50))
    returns int
    deterministic
begin
    return (select count(*)
            from employees as e
                     join addresses as a on e.address_id = a.address_id
                     join towns as t on a.town_id = t.town_id
            where t.name = town_name);
end $$

delimiter ;
;
select ufn_count_employees_by_town('Sofia') as count;
select name, ufn_count_employees_by_town(name) as count
from towns;

# 2 Procedures
delimiter $$
create procedure usp_select_employees()
begin
    select * from employees;
end $$
delimiter ;
;
call usp_select_employees();

# Procedures with parameters
delimiter $$
create procedure usp_select_employees(max_id int)
begin
    select * from employees where employee_id < max_id;
end $$
delimiter ;
;
call usp_select_employees(35);

delimiter $$
create procedure usp_raise_salaries(percent decimal(3, 2), out total_increase DECIMAL(19, 4))
begin
    declare local_increase decimal(19, 2);
    set local_increase := (select sum(salary) * (1 + percent) - sum(salary) as total_sum from employees);
    set total_increase = local_increase;
    update employees set salary = salary * (1 + percent);

end $$
delimiter ;
;

set @increase = 0;

call usp_raise_salaries(5, @increase);

select @increase;

#  lab.2 - parameter percent
delimiter $$
create procedure usp_raise_salaries_by_diven_percent(percent decimal(3, 2))
begin
    declare actual_percent decimal(3, 2);
    set actual_percent = 1 + percent / 100;
    update employees set salary = salary * actual_percent;
end $$
delimiter ;
;

call usp_raise_salaries_by_diven_percent(5);

select *
from employees
where department_id = 10
order by first_name, salary;


# Lab 2 - parameter department
delimiter $$
create procedure usp_raise_salaries(department_name varchar(50))
begin
    update employees as e
        join departments as d on d.department_id = e.department_id
    set salary = salary * 1.05
    where d.name = department_name;
end $$
delimiter ;
;


# Transactions
delimiter $$
create procedure usp_raise_salary_by_id(id int)
begin
    start transaction;
    if ((select count(*) from employees where employee_id = id) <> 1)
    then
        rollback;
    else
        update employees
        set salary = salary * 1.05
        where employee_id = id;
        commit;
    end if;
end $$

delimiter ;
;

select *
from employees
where employee_id = 17;
call usp_raise_salary_by_id(17);