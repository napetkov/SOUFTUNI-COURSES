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
create function ufn_get_salary_level(employee_salary decimal(10, 2))
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
    return result;
end $$
delimiter ;
;

select first_name,
       ufn_get_salary_level((select salary from employees as e where em.employee_id = e.employee_id)) as salary_level
from employees as em;

# 6
delimiter $$
create procedure usp_get_employees_by_salary_level(salary_level varchar(20))
begin
    select first_name, last_name
    from employees as e
    where ufn_get_salary_level(e.salary) = salary_level
    order by first_name desc, last_name desc;
end $$
delimiter ;
;

call usp_get_employees_by_salary_level('Average');

# 7
delimiter $$
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
    returns int
    deterministic
begin
    declare i int default 1;
    declare current_letter char(1);
    declare is_comprised int default 1;

    word_loop:
    while i <= length(set_of_letters)
        do
            set current_letter = substring(word, i, 1);

            if locate(current_letter, set_of_letters) = 0 then
                set is_comprised = 0;
                leave word_loop;
            end if;

            set i = i + 1;
        end while;
return is_comprised;
    end $$
delimiter ;
;

select ufn_is_word_comprised('oistmiahf', 'Sofia') as result;
select ufn_is_word_comprised('oistmiahf', 'halves') as result;




