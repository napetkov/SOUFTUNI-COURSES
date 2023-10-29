INSERT into users(id, active, email, first_name, last_name, password)
VALUES (1, 1, 'admin@example.com', 'Admin', 'Adminov',
        '17b7c4ddf2f811e58b54fffad57f53c3f40b856ef4b6f7d9ae394f139966212b80fc7811f83760cec0dba5c51a19031f'),
       (2, 1, 'user@example.com', 'User', 'Userov',
        '17b7c4ddf2f811e58b54fffad57f53c3f40b856ef4b6f7d9ae394f139966212b80fc7811f83760cec0dba5c51a19031f');

INSERT into roles(id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT into users_roles(user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);


insert into brands(id, name)
VALUES (1, 'Toyota'),
       (2, 'Ford');

insert into models(id, category, name, brand_id)
VALUES (1, 'CAR', 'Camry', 1),
       (2, 'CAR', 'Corolla', 1),
       (3, 'CAR', 'Focus', 2),
       (4, 'CAR', 'Fiesta', 2);