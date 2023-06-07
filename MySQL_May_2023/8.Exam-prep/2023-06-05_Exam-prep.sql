create database online_stores_db;
use online_stores_db;

# 1
create table brands
(
    id     int primary key auto_increment not null,
    `name` varchar(40) unique             not null
);

create table categories
(
    id     int primary key auto_increment not null,
    `name` varchar(40) unique             not null
);

create table reviews
(
    id           int primary key not null auto_increment,
    content      text,
    rating       decimal(10, 2)  not null,
    picture_url  varchar(80)     not null,
    published_at datetime        not null
);

create table products
(
    id                int primary key auto_increment not null,
    `name`            varchar(40)                    not null,
    price             decimal(19, 2)                 not null,
    quantity_in_stock int,
    description       text,
    brand_id          int                            not null,
    category_id       int                            not null,
    review_id         int,
    constraint fk_products_brands
        foreign key (brand_id)
            references brands (id),
    constraint fk_products_category
        foreign key (category_id)
            references categories (id),
    constraint fk_products_reviews
        foreign key (review_id)
            references reviews (id)
);

create table customers
(
    id            int primary key auto_increment not null,
    first_name    varchar(20)                    not null,
    last_name     varchar(20)                    not null,
    phone         varchar(30) unique             not null,
    address       varchar(60)                    not null,
    discount_card bit(1)                         not null default false
);

# alter table customers
# modify column discount_card bit(1) not null default false;


create table orders
(
    id             int primary key auto_increment not null,
    order_datetime datetime                       not null,
    customer_id    int                            not null,
    constraint fk_orders_customers
        foreign key (customer_id)
            references customers (id)
);

create table orders_products
(
    order_id   int,
    product_id int,
    constraint fk_orders_products_orders
        foreign key (order_id)
            references orders (id),
    constraint fk_orders_products_products
        foreign key (product_id)
            references products (id)
);

# 2
insert into reviews(content, picture_url, published_at, rating)
select substring(description, 1, 15) as content,
       reverse(`name`)               as picture_url,
       date('2010-10-10')            as published_at,
       (price / 8)                   as rating
from products
where id >= 5;

# 3
update products
set quantity_in_stock = quantity_in_stock - 5
where quantity_in_stock between 60 and 70;

# 4
delete c
from customers as c
         left join orders as o on c.id = o.customer_id
where o.id is null;

# 5
select id, `name`
from categories
order by `name` desc;

# 6
select id, brand_id, name, quantity_in_stock
from products
where price > 1000
  and quantity_in_stock < 30
order by quantity_in_stock asc, id;

# 7
select id, content, rating, picture_url, published_at
from reviews
where content like 'My%'
  and char_length(content) > 61
order by rating desc;

# 8
select concat_ws(' ', first_name, last_name) as full_name,
       address,
       order_datetime
from customers
         join orders as o on customers.id = o.customer_id
where year(order_datetime) <= 2018
order by full_name desc;

# 9
select count(p.id)              as items_count,
       c.name                   as name,
       sum(p.quantity_in_stock) as total_qunatity
from products as p
         join categories c on p.category_id = c.id
group by category_id
order by items_count desc, TOTAL_QUNATITY asc
limit 5;

# show variables like 'sql_mode';
# set sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

# 10
delimiter $$
create function udf_customer_products_count(name VARCHAR(30))
    returns int
    deterministic
begin
    return (select count(op.product_id)
            from customers
                     join orders o on customers.id = o.customer_id
                     join orders_products op on o.id = op.order_id
            where customers.first_name = name
            group by customer_id);
end $$
delimiter ;
;

# 11
delimiter $$
create procedure udp_reduce_price(category_name varchar(50))
begin
    update products as p
        join reviews r on r.id = p.review_id
        join categories c on p.category_id = c.id
    set p.price = p.price * 0.70
    where c.name = category_name
      and r.rating
        < 4;
end $$
delimiter ;


call udp_reduce_price('Phones and tablets');

select *
from products
where products.category_id = 1;