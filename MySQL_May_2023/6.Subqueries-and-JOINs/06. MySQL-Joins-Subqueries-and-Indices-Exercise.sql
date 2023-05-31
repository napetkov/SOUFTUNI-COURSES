# 1
select employee_id, job_title, e.address_id, address_text
from employees as e
         join addresses as a on a.address_id = e.address_id
order by address_id
limit 5;

# 2
select first_name, last_name, t.name, address_text
from employees
         join addresses a on a.address_id = employees.address_id
         join towns t on a.town_id = t.town_id
order by first_name asc, last_name
limit 5;

# 3
select employee_id, first_name, last_name, d.name as department_name
from employees as e
         join departments as d on d.department_id = e.department_id
where d.name = 'Sales'
order by employee_id desc;

# 4
select employee_id, first_name, salary, d.name as department_name
from employees as e
         join departments as d on e.department_id = d.department_id
where e.salary > 15000
order by d.department_id desc
limit 5;

# 5
select e.employee_id, first_name
from employees as e
         left join employees_projects as ep on ep.employee_id = e.employee_id
where ep.project_id is null
order by employee_id desc
limit 3;

# 6
select first_name, last_name, hire_date, d.name as `department_name`
from employees e
         join departments as d on d.department_id = e.department_id and d.name in ('Sales', 'Finance')
where hire_date > 1999 / 01 / 01
order by hire_date asc;

use soft_uni
# 7
select e.employee_id, e.first_name, p.name as project_name
from employees as e
         join employees_projects as ep on e.employee_id = ep.employee_id
         join projects as p on ep.project_id = p.project_id
where DATE(p.start_date) > '2002-08-13'
  and p.end_date is null
order by e.first_name, p.name
limit 5;

# 8
select e.employee_id, first_name, if(year(p.start_date) >= 2005, null, p.name) as project_name
from employees e
         join employees_projects ep
              on ep.employee_id = e.employee_id
         join projects p on p.project_id = ep.project_id
where ep.employee_id = 24
order by project_name asc;

# 9
select e.employee_id, e.first_name, e.manager_id, m.first_name
from employees e
         join employees m on m.employee_id = e.manager_id
where e.manager_id in (7, 3)
order by e.first_name;

# 10
select e.employee_id,
       concat(e.first_name, ' ', e.last_name) as employee_name,
       concat(m.first_name, ' ', m.last_name) as manager_name,
       d.name                                 as department_name
from employees e
         join employees m on m.employee_id = e.manager_id
         join departments d on d.department_id = e.department_id
order by employee_id
limit 5;

# 11
select min(avg_salary)
from (select avg(salary) as avg_salary
      from employees
      group by department_id) as min_average_salary;


# 12
select c.country_code, m.mountain_range, p.peak_name, p.elevation
from countries c
         join mountains_countries mc on c.country_code = mc.country_code
         join mountains m on m.id = mc.mountain_id
         join peaks p on p.mountain_id = m.id
where c.country_code = 'BG'
  and p.elevation > 2835
order by elevation desc;
# 13
select c.country_code, count(m.mountain_range) as mountain_range
from countries c
         join mountains_countries mc on mc.country_code = c.country_code
         join mountains m on m.id = mc.mountain_id
where c.country_code in ('US', 'RU', 'BG')
group by c.country_code
order by mountain_range desc;

# 14 - we can do with one join else if we use continent code = 'AF' instead of 'Africa'
select country_name, r.river_name
from countries c
         join continents con on con.continent_code = c.continent_code
         left join countries_rivers cr on cr.country_code = c.country_code
         left join rivers r on r.id = cr.river_id
where con.continent_name = 'Africa'
order by country_name asc
limit 5;

# 15
use geography;
select country_code, currency_code, count(*) as `currency_usage`
from countries as c
group by c.continent_code, c.currency_code
having currency_usage > 1
   and currency_usage = (select count(*) as count_of_currencies
                         from countries as c2
                         where c2.continent_code = c.continent_code
                         group by c2.currency_code
                         order by count_of_currencies desc
                         limit 1)
order by c.continent_code, c.currency_code;


select count(*) as count_of_currencies
from countries as c2
where c2.continent_code = c2.continent_code
group by c2.currency_code
order by count_of_currencies desc
limit 1;


# select continent_code, currency_code, count(currency_code)
# from countries
# group by currency_code;
#
# select continent_code, currency_code, max(count_currency) as currency_usage
# from (select c.continent_code,
#              c.currency_code,
#              count(*) as count_currency
#       from countries AS c
#       group by c.continent_code, c.currency_code
#       having count_currency > 1) as cont
# group by continent_code
# order by continent_code;
#
# select c.continent_code,
#        c.currency_code,
#        count(continent_code) as count_currency
# from countries AS c
# group by c.continent_code, c.currency_code;

# show variables like 'sql_mode';
# set sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION'


# 16
select count(c.country_code)
from countries c
         left join mountains_countries mc on mc.country_code = c.country_code
         left join mountains m on m.id = mc.mountain_id
where m.id is null;

# 17
select country_name, max(p.elevation) as higest_peak_elevation, max(r.length) as longest_river_length
from countries c
         join mountains_countries mc on c.country_code = mc.country_code
         join mountains m on mc.mountain_id = m.id
         join peaks p on m.id = p.mountain_id
         join countries_rivers cr on cr.country_code = c.country_code
         join rivers r on cr.river_id = r.id
group by country_name
order by higest_peak_elevation desc, longest_river_length desc, country_name
limit 5;
