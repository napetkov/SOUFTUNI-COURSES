select department_id,
       (salary) as `Total Salaries`
from employees
group by department_id;

select *
from employees;

select department_id, count(first_name) as `Count of employees`, round(avg(salary), 2) as `Average salary`
from employees
group by department_id;

# 1
select department_id, count(id) as `Number of employees`
from employees
group by department_id
order by department_id, `Number of employees`;

# 2
select department_id, round(avg(salary), 2)
from employees
group by department_id
order by department_id;

# 3
select department_id, round(min(salary), 2) as `Min Salary`
from employees
group by department_id
having `Min Salary` > 800;

# 4
select count(id)
from products
where price > 8
  and category_id = 2;

# 5
select category_id,
       round(avg(price), 2) as `Average Price`,
       round(min(price), 2) as `Cheapest Product`,
       round(max(price), 2) as `Most Expensive Product`
from products
group by (category_id);
