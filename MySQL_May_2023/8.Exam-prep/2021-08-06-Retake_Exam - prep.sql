# 1
create table addresses
(
    id     int primary key auto_increment not null,
    `name` varchar(50)                    not null
);

create table categories
(
    id     int primary key auto_increment not null,
    `name` varchar(10)                    not null
);

create table offices
(
    id                 int primary key auto_increment not null,
    workspace_capacity int                            not null,
    website            varchar(50),
    address_id         int                            not null,
    constraint fk_offices_addresses
        foreign key (address_id)
            references addresses (id)
);

create table employees
(
    id              int primary key auto_increment not null,
    first_name      varchar(30)                    not null,
    last_name       varchar(30)                    not null,
    age             int                            not null,
    salary          decimal(10, 2)                 not null,
    job_title       varchar(20)                    not null,
    happiness_level char(1)                        not null
);

create table teams
(
    id        int primary key auto_increment not null,
    `name`    varchar(40)                    not null,
    office_id int                            not null,
    leader_id int                            not null unique,
    constraint fk_teams_offices
        foreign key (office_id)
            references offices (id),
    constraint fk_teams_employees
        foreign key (leader_id)
            references employees (id)
);

create table games
(
    id           int primary key auto_increment not null,
    `name`       varchar(50)                    not null unique,
    description  text,
    rating       float default 5.5              not null,
    budget       decimal(10, 2)                 not null,
    release_date date,
    team_id      int                            not null,
    constraint fk_games_teams
        foreign key (team_id)
            references teams (id)
);

create table games_categories
(
    game_id     int not null,
    category_id int not null,
    constraint pk_games_id_category_id
        primary key (game_id, category_id),
    constraint fk_games_categories_games
        foreign key (game_id)
            references games (id),
    constraint fk_games_categories_categories
        foreign key (category_id)
            references categories (id)
);

# 2
insert into games(name, rating, budget, team_id)
select lower(reverse(substring(t.name, 2))),
       t.id,
       t.leader_id * 1000,
       t.id
from teams as t
where t.id between 1 and 9;

# 3
update employees as e
    join teams t on e.id = t.leader_id
set e.salary = e.salary + 1000
where t.leader_id = e.id
  and age < 40
  and salary <= 5000;

# 4
delete g
from games as g
         left join games_categories as gc on g.id = gc.game_id
where g.release_date is null
  and gc.category_id is null;

# 5
select first_name, last_name, age, salary, happiness_level
from employees
order by salary, id;

# 6
select t.name              as team_name,
       a.name              as address_name,
       char_length(a.name) as count_of_characters
from teams as t
         left join offices o on t.office_id = o.id
         left join addresses a on a.id = o.address_id
where o.website is not null
order by t.name, a.name;

# 7
select
    c.name as name,
    count(g.id) as games_count,
    round(avg(g.budget),2) as avg_budget,
    max(g.rating) as max_rating
from categories as c
         join games_categories as gc on c.id = gc.category_id
         join games as g on gc.game_id = g.id
group by (c.name)
having max_rating >= 9.5
order by games_count desc, name ;