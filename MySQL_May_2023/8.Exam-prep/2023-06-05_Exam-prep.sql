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

create table customers(
    id int primary key auto_increment not null ,
    first_name varchar(20) not null ,
    last_name varchar(20) not null ,
    phone varchar(30) unique not null ,
    address varchar(60) not null ,
    discount_card bit(1) not null default false
);

# alter table customers
# modify column discount_card bit(1) not null default false;


create table orders(
    id int primary key auto_increment not null ,
    order_datetime datetime not null ,
    customer_id int not null ,
    constraint fk_orders_customers
                   foreign key (customer_id)
                   references customers(id)
);

create table orders_products(
    order_id int,
    product_id int,
    constraint fk_orders_products_orders
                            foreign key (order_id)
                            references orders(id),
                            constraint fk_orders_products_products
                            foreign key (product_id)
                            references products(id)
);

# 2
insert into reviews(content, picture_url, published_at,rating)
select
    substring(description,1,15) as content,
    reverse(`name`) as picture_url,
    2010-10-10 as published_at,
    (price / 8) as rating
from products
where id >= 5;
