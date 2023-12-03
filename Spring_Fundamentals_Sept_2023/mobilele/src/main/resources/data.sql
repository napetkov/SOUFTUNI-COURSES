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
       (2, 'Ford'),
       (3, 'Trabant');

insert into models(id, category, name, brand_id)
VALUES (1, 'CAR', 'Camry', 1),
       (2, 'CAR', 'Corolla', 1),
       (3, 'CAR', 'Focus', 2),
       (4, 'CAR', 'Fiesta', 2),
       (5, 'CAR', '601', 3);

INSERT INTO `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `uuid`, `year`,
                      `model_id`)
VALUES (1, 'TOP TOP TOP', 'PETROL',
        'https://www.gannett-cdn.com/media/2017/11/03/USATODAY/USATODAY/636453148225279748-GettyImages-458621516.jpg?width=592&format=pjpg&auto=webp&quality=70',
        60000, 2100.00, 'MANUAL', '2aba2975-aa41-4071-aec1-cee71a6e4625', 1985, 5),
       (2, 'TOP TOP TOP', 'PETROL',
        'https://www.gannett-cdn.com/media/2017/11/03/USATODAY/USATODAY/636453148225279748-GettyImages-458621516.jpg?width=592&format=pjpg&auto=webp&quality=70',
        61000, 2200.00, 'MANUAL', '2aba2975-aa41-4071-aec1-cee71a6e4626', 1986, 5),
       (3, 'TOP TOP TOP', 'PETROL',
        'https://www.gannett-cdn.com/media/2017/11/03/USATODAY/USATODAY/636453148225279748-GettyImages-458621516.jpg?width=592&format=pjpg&auto=webp&quality=70',
        62000, 2300.00, 'MANUAL', '2aba2975-aa41-4071-aec1-cee71a6e4627', 1987, 5),
       (4, 'TOP TOP TOP', 'PETROL',
        'https://www.gannett-cdn.com/media/2017/11/03/USATODAY/USATODAY/636453148225279748-GettyImages-458621516.jpg?width=592&format=pjpg&auto=webp&quality=70',
        63000, 2400.00, 'MANUAL', '2aba2975-aa41-4071-aec1-cee71a6e4628', 1988, 5),
       (5, 'TOP TOP TOP', 'PETROL',
        'https://www.gannett-cdn.com/media/2017/11/03/USATODAY/USATODAY/636453148225279748-GettyImages-458621516.jpg?width=592&format=pjpg&auto=webp&quality=70',
        64000, 2500.00, 'MANUAL', '2aba2975-aa41-4071-aec1-cee71a6e4629', 1989, 5);
