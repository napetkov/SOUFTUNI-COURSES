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
    select first_name, last_name
    from employees
    where salary >= min_salary
    order by first_name, last_name, employee_id asc;
end $$
delimiter ;
;

# 3
delimiter $$
create procedure usp_get_towns_starting_with(starting_string varchar(20))
begin
    select name as town_name
    from towns as t
    where lower(t.name) like concat(starting_string, '%%')
    order by town_name;
end $$
delimiter ;
;

call usp_get_towns_starting_with('b');

# 4
delimiter $$
create procedure usp_get_employees_from_town(town_name varchar(20))
begin
    select first_name, last_name
    from employees as e
             join addresses a on e.address_id = a.address_id
             join towns as t on a.town_id = t.town_id
    where t.name = town_name
    order by first_name, last_name, e.employee_id;
end $$
delimiter ;
;

call usp_get_employees_from_town('Sofia');

# 5
delimiter $$
create function ufn_get_salary_level(employee_salary decimal(9, 4))
    returns varchar(10)
    deterministic
begin
    #     return (select case
#                        when employee_salary < 30000 then 'Low'
#                        when employee_salary between 30000 and 50000 then 'Average'
#                        when employee_salary > 500000 then 'High'
#                        end as salary_level);
    declare result varchar(20);
    if employee_salary < 30000 then
        set result = 'Low';
    elseif employee_salary between 30000 and 50000 then
        set result = 'Average';
    else
        set result = 'High';
    end if;
    return result ;
end $$
delimiter ;
;

select ufn_get_salary_level(13500.00) as salary_level;



