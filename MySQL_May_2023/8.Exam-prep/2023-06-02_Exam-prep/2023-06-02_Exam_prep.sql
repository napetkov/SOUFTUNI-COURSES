# 1
create database restaurant_db;
use restaurant_db;

create table products
(
    id    int primary key auto_increment not null,
    name  varchar(30)                    not null unique,
    type  varchar(30)                    not null,
    price decimal(10, 2)                 not null
);

create table clients
(
    id         int primary key auto_increment not null,
    first_name varchar(50)                    not null,
    last_name  varchar(50)                    not null,
    birthdate  date                           not null,
    card       varchar(50),
    review     text
);

create table tables
(
    id       int primary key auto_increment not null,
    floor    int                            not null,
    reserved boolean,
    capacity int                            not null
);

create table waiters
(
    id         int primary key auto_increment not null,
    first_name varchar(50)                    not null,
    last_name  varchar(50)                    not null,
    email      varchar(50)                    not null,
    phone      varchar(50),
    salary     decimal(10, 2)
);

create table orders
(
    id           int primary key auto_increment not null,
    table_id     int                            not null,
    waiter_id    int                            not null,
    order_time   time,
    payed_status boolean
);

alter table orders
    add constraint fk__orders_table_id__tables_id foreign key
        (table_id) references tables (id),
    add constraint fk__orders_waiter_id__waiters_id
        foreign key (waiter_id)
            references waiters (id);

create table orders_clients
(
    order_id  int,
    client_id int,
    constraint fk__orders_clients_order_id__order_id
        foreign key (order_id)
            references orders (id),
    constraint fk__orders_clients_client_id__clients_id
        foreign key (client_id)
            references clients (id)
);

create table orders_products
(
    order_id   int,
    product_id int,
    constraint fk__orders_clients_order_id__orders_id
        foreign key (order_id)
            references orders (id),
    constraint fk__orders_products_product_id__products_id
        foreign key (product_id)
            references products (id)
);

# 2
insert into products(name, type, price)
select concat_ws(' ', last_name, 'specialty') as name,
       'Cocktail'                             as type,
       ceiling(salary * 0.01)                 as price
from waiters
where id > 6;

# 3
update orders
set table_id = table_id - 1
where id between 12 and 23;

# 4
delete w
from waiters as w
         left join orders o on w.id = o.waiter_id
where o.id is null;

# 5
select *
from clients
order by birthdate desc, id desc;

# 6
select first_name, last_name, birthdate, review
from clients as c
where c.card is null
  and year(birthdate) between 1978 and 1993
order by last_name desc, id asc
limit 5;

# 7
alter table waiters
    drop username,
    drop password;
# insert into waiters(username,password)
# values;
select concat(
               last_name,
               first_name,
               length(first_name),
               'Restaurant')              as username,
       reverse(substring(w.email, 2, 12)) as password
from waiters as w
where w.salary is not null
order by password desc;

# 8
select p.id, p.name, count(p.id) as count
from orders as o
         join orders_products as op on o.id = op.order_id
         join products p on op.product_id = p.id
group by p.name
having count >= 5
order by count desc, p.name asc;

# 9
show variables like 'sql_mode'
set sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

select id,
       capacity,
       count_clients,
       (case
            when count_clients > capacity then 'Extra seats'
            when count_clients = capacity then 'Full'
            when count_clients < capacity then 'Free seats'
           end)
           as availability
from (select t.id, t.capacity, count(oc.client_id) as count_clients
      from tables as t
               join orders o on t.id = o.table_id
               join orders_clients oc on o.id = oc.order_id
      where t.floor = 1
      group by (t.id)) as count_of_sit_people
order by id desc;

# 10
delimiter $$
create function udf_client_bill(full_name VARCHAR(50))
    returns decimal(10, 2)
    deterministic
begin
    return (select sum(price)
            from clients as c
                     join orders_clients as oc on c.id = oc.client_id
                     join orders_products as op on oc.order_id = op.order_id
                     join products as p on p.id = op.product_id
            where concat_ws(' ', c.first_name, c.last_name) = full_name);
end $$
delimiter ;


# 11
delimiter $$
create procedure udp_happy_hour (type varchar(50))
begin
update products as p
    set price = price * 0.80
    where p.type = type and price >= 10;
end $$
delimiter ;

select * from products as p
where p.type = 'Cognac';