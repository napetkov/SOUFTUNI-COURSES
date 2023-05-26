# 1
select first_name,
       last_name
from employees
where lower(first_name) like 'sa%'
order by employee_id;

# 2
select first_name,
       last_name
from employees
where upper(last_name) like upper('%ei%')
order by employee_id;

# 3
select first_name
from employees
where (department_id = 3 or department_id = 10)
  and (extract(YEAR from employees.hire_date) >= 1995 and extract(year from employees.hire_date) <= 2005)
order by employee_id;
# and year(hire_date) between 1995 and 2005 .......


# 4
select first_name, last_name
from employees
where lower(job_title) not like '%engineer%'
order by employee_id;

# 5
select name
from towns
where char_length(name) = 5
  and char_length(name) = 6
order by name asc;
# between 5 and 6

# 6
select town_id, name
from towns
where name regexp '^[M, K, B, E]'
order by name asc;
#lower(name) like 'm%'
#lower(name) like 'k%' ....
# lower left(name, 1) in ('m' , 'k', ...)
# 7
select town_id, name
from towns
where name regexp '^[^Rr, Bb, Dd]'
order by name asc;

# 8
create view v_employees_hired_after_2000 as
select first_name, last_name
from employees
where extract(year from hire_date) > 2000;


select *
from v_employees_hired_after_2000;

# 9
select first_name, last_name
from employees
where char_length(last_name) = 5;

# 10
select country_name, iso_code
from countries
where country_name like '%a%a%a%'
order by iso_code;

# 10.2
select country_name, iso_code
from countries
# where char_length(regexp_replace(country_name, '[^Aa]', '')) >= 3
where (char_length(country_name) - char_length(replace(lower(country_name), 'a', ''))) >= 3
order by iso_code;


# 11
select p.peak_name,
       r.river_name,
       concat(LOWER(p.peak_name), lower(substr(r.river_name from 2))) as mix
# for right side of mix can use right(r.river_name, lenght(r.river_name)-1)
from peaks as p,
     rivers as r
where lower(right(p.peak_name, 1)) like lower(left(r.river_name, 1))
order by mix;


# 12
select name, date_format(start, '%Y-%m-%d')
from games
where year(start) = 2011
   or year(start) = 2012
order by start
limit 50;


# 13
select user_name,
       substring(email, LOCATE('@', email) + 1) as `email provider`
# substring_index(email, '@', -1)
# regexp_replace(email, '.*@', '')
from users
order by `email provider`, user_name;

# 14
select user_name, ip_address
from users
where ip_address like '___.1%.%.___'
order by user_name;


# 15
select name    as game,
       case
           when hour(start) between 0 and 11 then 'Morning'
           when hour(start) between 12 and 17 then 'Afternoon'
           else 'Evening'
           end as `Part of the date`,
       case
           when duration <= 3 then 'Extra Short'
           when duration > 3 and duration <= 6 then 'Short'
           when duration > 6 and duration <= 10 then 'Long'
           else 'Extra Long'
           end as `Duration`
from games
order by id asc;

# 16
select product_name,
       order_date,
       date_add(order_date, interval 3 day) as pay_due,
       date_add(order_date, interval 1 month ) as delivery_due
from orders;