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
select e.employee_id, first_name, ep.project_id from employees as e
left join employees_projects as ep on ep.employee_id = e.employee_id
where ep.project_id is null
order by employee_id desc
limit 3;

# 6

