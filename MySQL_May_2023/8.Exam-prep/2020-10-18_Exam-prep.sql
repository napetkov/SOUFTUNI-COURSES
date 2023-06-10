# 1
create table pictures
(
    id       int primary key auto_increment not null,
    url      varchar(100)                   not null,
    added_on datetime                       not null
);

create table categories
(
    id     int primary key auto_increment not null,
    `name` varchar(40)                    not null unique
);

create table products
(
    id          int primary key auto_increment not null,
    `name`      varchar(40) unique             not null,
    best_before date,
    price       decimal(10, 2)                 not null,
    description text,
    category_id int                            not null,
    picture_id  int                            not null,
    constraint fk_products_categories
        foreign key (category_id)
            references categories (id),
    constraint fk_products_pictures
        foreign key (picture_id)
            references pictures (id)
);

create table towns
(
    id     int primary key auto_increment not null,
    `name` varchar(20) unique             not null
);

create table addresses
(
    id      int primary key auto_increment not null,
    `name`  varchar(50) unique             not null,
    town_id int                            not null,
    constraint fk_addresses_towns
        foreign key (town_id)
            references towns (id)
);

create table stores
(
    id          int primary key auto_increment not null,
    `name`      varchar(20) unique             not null,
    rating      float                          not null,
    has_parking tinyint(1) default false,
    address_id  int                            not null,
    constraint fk_stores_addresses
        foreign key (address_id)
            references addresses (id)
);

create table products_stores
(
    product_id int not null,
    store_id   int not null,
    constraint pk_products_stores
        primary key (product_id, store_id),
    constraint pk_products_stores_products
        foreign key (product_id)
            references products (id),
    constraint fk_products_stores_stores
        foreign key (store_id)
            references stores (id)
);

create table employees
(
    id          int primary key auto_increment not null,
    first_name  varchar(15)                    not null,
    middle_name char(1),
    last_name   varchar(20)                    not null,
    salary      decimal(19, 2) default 0,
    hire_date   date                           not null,
    manager_id  int,
    store_id    int                            not null,
    constraint fk_employees_stores
        foreign key (store_id)
            references stores (id),
    constraint fk_employees_id__manager_id
        foreign key (manager_id)
            references employees (id)
);

# 2
insert into products_stores(product_id, store_id)
select p.id, 1
from products as p
         left join products_stores ps on p.id = ps.product_id
where ps.store_id is null;

# 3
update employees as e
    join stores s on e.store_id = s.id
set e.manager_id = 3,
    e.salary     = e.salary - 500
where year(e.hire_date) > 2003
  and (s.name != 'Cardguard' and s.name != 'Veribet');

# 4
delete e
from employees as e
where manager_id is not null
  and salary >= 6000;

# 5
select first_name,
       middle_name,
       last_name,
       salary,
       hire_date
from employees
order by hire_date desc;

# 6
select p.name                                         as product_name,
       price,
       best_before,
       concat(substring(p.description, 1, 10), '...') as short_description,
       url
from products as p
         join pictures pic on pic.id = p.picture_id
where char_length(p.description) > 100
  and price > 20
  and year(pic.added_on) < 2019
order by p.price desc

# 7
select
    s.name,
    count(ps.product_id) as product_count,
    round(avg(p.price), 2)as avg
from stores as s
        left join products_stores ps on s.id = ps.store_id
        left join products p on ps.product_id = p.id
group by s.id
order by product_count desc ,avg desc , s.id;
