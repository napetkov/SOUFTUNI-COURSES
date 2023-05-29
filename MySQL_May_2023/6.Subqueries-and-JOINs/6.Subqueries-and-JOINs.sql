select first_name, department_id, d.name
from employees as e
         join departments as d on e.department_id = d.id;
# all insert in left(from table)
select *
from employees as e
         left join departments d on e.department_id = d.id;

# all insert in right(join table)
select first_name, department_id, d.name
from employees as e
         right join departments as d on e.department_id = d.id;

# all insert in selected and joined tables
select first_name, department_id, d.name
from employees as e
         left join departments d on d.id = e.department_id

union

select first_name, department_id, d.name
from employees as e
         right join departments d on d.id = e.department_id;

# Cross join
select first_name, department_id, departments.name
from employees
         cross join departments;

# 1

select d.manager_id, concat(first_name, ' ', last_name) as full_name, d.department_id, d.name
from employees as e
         join departments as d on d.manager_id = e.employee_id
order by employee_id
limit 5;

# 2

select t.town_id,
       t.name
           as town_name,
       a.address_text
from towns t
         join addresses a on t.town_id = a.town_id
where name in ('San Francisco', 'Sofia', 'Carnation')
order by town_id, address_id;

# 3
select employee_id, first_name, last_name, department_id, salary
from employees
where manager_id is null;

# 4
select count(salary) as count
from employees
where (select avg(salary) from employees) < employees.salary ;
