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
select c.name                  as name,
       count(g.id)             as games_count,
       round(avg(g.budget), 2) as avg_budget,
       max(g.rating)           as max_rating
from categories as c
         join games_categories as gc on c.id = gc.category_id
         join games as g on gc.game_id = g.id
group by (c.name)
having max_rating >= 9.5
order by games_count desc, name;

# 8
select g.name,
       g.release_date,
       concat(substring(g.description, 1, 10), '...') as summary,
       case
           when month(g.release_date) between 1 and 3 then 'Q1'
           when month(g.release_date) between 4 and 6 then 'Q2'
           when month(g.release_date) between 7 and 9 then 'Q3'
           when month(g.release_date) between 10 and 12 then 'Q4'
           end                                        as quarter,
       t.name
from games as g
         join teams t on t.id = g.team_id
where substring(g.name, char_length(g.name) - 1) = 2
  and year(g.release_date) = 2022
  and month(g.release_date) % 2 = 0
order by quarter;

# 9
select g.name,
       IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') as budget_level,
       t.name,
       a.name
from games as g
         join teams as t on g.team_id = t.id
         join offices o on o.id = t.office_id
         join addresses a on a.id = o.address_id
         left join games_categories gc on g.id = gc.game_id
where g.release_date is null
  and gc.category_id is null
order by g.name;

# select g.name,
#        if(g.budget < 50000, 'Normal budget', 'Insufficient budget') as budget_level,
#        t.name                                                       as team_name,
#        a.name                                                       as address_name
# from games as g
#          left join teams as t on t.id = g.team_id
#          left join games_categories as gc on gc.game_id = g.id
#          left join categories as c on c.id = gc.category_id
#          join offices as o on o.id = t.office_id
#          join addresses as a on a.id = o.address_id
# where g.release_date is null
#   AND c.name is null
# order by g.name;


# 10
delimiter //
create function udf_game_info_by_name(game_name VARCHAR(20))
    returns text
begin
    return (select concat_ws(' ', 'The', g.name, 'is developed by a', t.name, 'in an office with an address', a.name)
            from games as g
                     join teams t on t.id = g.team_id
                     join offices o on o.id = t.office_id
                     join addresses a on a.id = o.address_id
            where g.name = game_name);
end //
delimiter ;

# 11
delimiter //
create procedure udp_update_budget(min_game_rating float)
begin
    update games as g
        left join games_categories gc on g.id = gc.game_id
    set g.budget = g.budget + 100000,
        g.release_date = date_add(g.release_date, interval 1 year)
       where category_id is null
      and rating > min_game_rating
      and g.release_date is not null;
end //
delimiter ;

call udp_update_budget(8);
SELECT SUM(`budget`)
FROM `games`;
