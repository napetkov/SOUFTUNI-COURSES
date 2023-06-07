create database softuni_imdb;
use softuni_imdb;
# 1
create table countries
(
    id        int primary key auto_increment not null,
    name      varchar(30) unique             not null,
    continent varchar(30)                    not null,
    currency  varchar(5)                     not null
);

create table genres
(
    id   int primary key auto_increment not null,
    name varchar(50)                    not null unique

);

create table actors
(
    id         int primary key auto_increment not null,
    first_name varchar(50)                    not null,
    last_name  varchar(50)                    not null,
    birthdate  date                           not null,
    height     int,
    awards     int,
    country_id int                            not null,
    constraint fk_actors_countries
        foreign key (country_id)
            references countries (id)

);

create table movies_additional_info
(
    id            int primary key auto_increment not null,
    rating        decimal(10, 2)                 not null,
    runtime       int,
    picture_url   varchar(80)                    not null,
    budget        decimal(10, 2),
    release_date  date                           not null,
    has_subtitles boolean,
    description   text
);

create table movies
(
    id            int primary key auto_increment not null,
    title         varchar(70)                    not null unique,
    country_id    int,
    movie_info_id int unique                     not null,
    constraint fk_movies_countries
        foreign key (country_id)
            references countries (id),
    constraint fk_movies_movies_additional_info
        foreign key (movie_info_id)
            references movies_additional_info (id)
);

create table movies_actors
(
    movie_id int,
    actor_id int,
    key pk_movie_actors (movie_id, actor_id),
    constraint fk__movies_actors__movies
        foreign key (movie_id)
            references movies (id),
    constraint fk__movies_actors__actors
        foreign key (actor_id)
            references actors (id)
);

create table genres_movies
(
    genre_id int,
    movie_id int,
    key pk_genres_movies (genre_id, movie_id),
    constraint fk__genres_movies__genre
        foreign key (genre_id)
            references genres (id),
    constraint fk__genres_movies__movies
        foreign key (movie_id)
            references movies (id)
);

# 2
insert into actors(first_name, last_name, birthdate, height, awards, country_id)
select reverse(first_name),
       reverse(last_name),
       date(a.birthdate - 2),
       a.height + 10,
       country_id,
       (select id from countries as c where c.name = 'Armenia')
from actors as a
where id <= 10;

# 3
update movies_additional_info
set runtime = runtime - 10
where id between 15 and 25;

# 4
delete c
from countries as c
         left join movies m on c.id = m.country_id
where m.id is null;

# 5
select id, name, continent, currency
from countries as c
order by currency desc, id;

# 6
select m.id, m.title, mai.runtime, mai.budget, mai.release_date
from movies_additional_info as mai
         join movies m on mai.id = m.movie_info_id
where year(release_date) between 1996 and 1999
order by runtime, id
limit 20;

# 7
select concat_ws(' ', a.first_name, a.last_name)                           as full_name,
       concat(reverse(a.last_name), char_length(a.last_name), '@cast.com') as email,
       (2022 - year(a.birthdate))                                          as age,
       a.height
from actors as a
         left join movies_actors as ma on ma.actor_id = a.id
where ma.movie_id is null
order by height;

# 9
select c.name      as name,
       count(m.id) as movies_count
from countries as c
         join movies m on c.id = m.country_id
group by c.name
having movies_count >= 7
order by name desc;

# 9
select m.title,
       (case
            when rating <= 4 then 'poor'
            when rating > 4 and rating <= 7 then 'good'
            else 'excellent'
           end) as rating,
       if(mai.has_subtitles, 'english', '-'),
       mai.budget
from movies as m
         join movies_additional_info mai on m.movie_info_id = mai.id
order by budget desc;

# 10
delimiter //
create function udf_actor_history_movies_count(full_name VARCHAR(50))
    returns int
deterministic
    begin
    return (select count(m.id)
    from movies as m
             join movies_actors ma on m.id = ma.movie_id
             join actors a on ma.actor_id = a.id
             join genres_movies gm on m.id = gm.movie_id
             join genres g on gm.genre_id = g.id
    where g.name = 'History'
      and concat(a.first_name, ' ', a.last_name) = full_name);
end //
delimiter ;

# 11
delimiter //
create procedure udp_award_movie(movie_title VARCHAR(50))
begin
    update actors as a
        join movies_actors as ma on a.id = ma.actor_id
        join movies as m on m.id = ma.movie_id
    set awards = awards + 1
    where m.title = movie_title;
end //
delimiter ;

select concat(a.first_name,' ', a.last_name), awards from movies as m
         join movies_actors ma on m.id = ma.movie_id
         join actors a on a.id = ma.actor_id
where title = 'Tea For Two';

call udp_award_movie('Tea For Two')