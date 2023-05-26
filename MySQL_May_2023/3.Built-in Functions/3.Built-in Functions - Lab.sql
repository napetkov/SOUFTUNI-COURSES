# 1
SELECT title
FROM books
WHERE substring(title, 1 , 3) = 'The'
ORDER BY id;

# 2
SELECT 
    REPLACE(title, 'The', '***') AS title
FROM
    books
WHERE
    SUBSTRING(title, 1, 3) = 'The'
ORDER BY id;

# TESTING STRING FUNCTIONS
select char_length('01234');
select length('01234');

select left('01234', 2);
select right('01234', 2);

select upper('abc');
select lower('ABC');

select repeat('ABC ', 4);

select locate('23','01234');

select insert('01234',3,0,'AB');
# integer division - return integer
select  5 div 2;

# 3.141593
select PI();

# absolut / modul
select abs(-100);

select sqrt(16);
select pow(4, 2);

# converts between different number base

select conv(123 , 10, 16);

select round(2.3564, 2), ceiling(2.3564), floor(2.3564);

select floor(rand() * 11);

select extract(YEAR_MONTH from '2023/05/18');
# 3
select round(sum(cost), 2) as 'total sum'
from books ;

# 4

select
    concat(authors.first_name , ' ', authors.last_name) as 'Full name',
    ABS(TIMESTAMPDIFF(day , authors.died, authors.born)) as 'Days Lived'
from authors;

# 5

select title
from books
where title like 'Harry Potter%';

