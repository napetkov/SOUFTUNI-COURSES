set global log_bin_trust_function_creators = 1;
set sql_safe_updates = 0;

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
    where lower(t.name) like concat(starting_string, '%')
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
# 7-2 with REGEXP
delimiter $$
create function ufn_is_word_comprised2(set_of_letters varchar(50), word varchar(50))
    returns int
    deterministic
begin
    return word regexp concat('^[',set_of_letters,']+$');
end $$
delimiter ;

select ufn_is_word_comprised2('oistmiahf', 'Sofia') as result;
select ufn_is_word_comprised2('oistmiahf', 'halves') as result;

# 8
delimiter $$
create procedure usp_get_holders_full_name()
begin
    select concat(first_name, ' ', last_name) as full_name
    from account_holders
    order by full_name;

end $$
delimiter ;
;

call usp_get_holders_full_name();

# 9
delimiter $$
create function ufn_calc_sum_of_balance(holder_id int)
    returns decimal(10, 4)
    deterministic
begin
    return (select sum(balance) as sum_balamnce
            from accounts as a
            where a.account_holder_id = holder_id
            group by account_holder_id);
end $$
delimiter ;
;

delimiter $$
create procedure usp_get_holders_with_balance_higher_than(border_of_money decimal(10, 4))
begin
    select first_name, last_name
    from account_holders as ah
             join accounts a on ah.id = a.account_holder_id
    where ufn_calc_sum_of_balance(a.account_holder_id) > border_of_money
    group by account_holder_id
    order by account_holder_id;
end $$
delimiter ;
;

call usp_get_holders_with_balance_higher_than(900000);

# 10
delimiter $$
create function ufn_calculate_future_value(initial_sum decimal(10, 4), interest double, years int)
    returns decimal(10, 4)
    deterministic
begin
    declare future_value decimal(10, 4);
    set future_value = initial_sum * (pow((1 + interest), years));
    return future_value;
end $$
delimiter ;
;

select ufn_calculate_future_value(1000, 0.5, 5);

# 11
delimiter $$
create procedure usp_calculate_future_value_for_account(id_account int, interest_rate decimal(10, 4))
begin
    select a.id                                                    as account_id,
           ah.first_name,
           ah.last_name,
           a.balance                                               as current_balance,
           ufn_calculate_future_value(a.balance, interest_rate, 5) as balance_in_5_years
    from accounts as a
             join account_holders ah on a.account_holder_id = ah.id
    where a.id = id_account;
end $$
delimiter ;
;

call usp_calculate_future_value_for_account(12, 0.0001);

# 12
delimiter $$
create procedure usp_deposit_money(account_id int, money_amount decimal(10, 4))
begin
    start transaction;
    if (money_amount < 0)
    then
        rollback;
    else
        update accounts as a
        set a.balance = a.balance + money_amount
        where a.id = account_id;
        commit;
    end if;
end $$
delimiter ;
;

call usp_deposit_money(1, 10);

# 13
delimiter $$
create procedure usp_withdraw_money(account_id int, money_amount decimal(10, 4))
begin
    declare amount_withdraw decimal(10, 4);
    set amount_withdraw = (select balance from accounts as a where a.id = account_id) - money_amount;
    start transaction;
    if
        (money_amount <= 0)
    then
        rollback ;
    elseif (amount_withdraw < 0)
    then
        rollback;
    else
        update accounts as a
        set a.balance = a.balance - money_amount
        where a.id = account_id;
        commit;
    end if;
end $$
delimiter ;
;

call usp_withdraw_money(2, 3);

select *
from accounts;