insert into books (id, author, available, description, genre, rating, title)
values  (1, 'George Orwell', false, 'A dystopian novel about totalitarianism', 1, 8.7, '1984'),
        (2, 'Joseph Heller', true, 'Often cited as one of the most significant novels of the twentieth century, it uses a distinctive non-chronological third-person omniscient narration, describing events from the points of view of different characters.', 0, 9.7, 'Catch-22'),
        (3, 'J.R.R. Tolkien', true, 'A fantasy adventure about a hobbit''s journey', 2, 4.3, 'The Hobbit'),
        (4, 'J.D. Salinger', true, 'A coming-of-age novel about teenage angst', 0, 5.1, 'The Catcher in the Rye'),
        (5, 'J.K. Rowling', true, 'The first book in the Harry Potter series', 2, 6.1, 'Harry Potter and the Sorcerer''s Stone'),
        (6, 'J.R.R. Tolkien', false, 'An epic fantasy trilogy', 1, 5.2, 'The Lord of the Rings'),
        (7, 'Aldous Huxley', true, 'A dystopian novel envisioning a future society', 1, 4.7, 'Brave New World'),
        (8, 'C.S. Lewis', true, 'A series of fantasy novels about Narnia', 2, 5.6, 'The Chronicles of Narnia');
insert into library_members (id, address, first_name, last_name, phone_number)
values  (1, '123 Main St', 'Ivan', 'Doe', '555-1111'),
        (2, '456 Elm St', 'Jane', 'Smith', '555-2222'),
        (3, null, 'Michael', 'Johnson', '555-3333'),
        (4, '555 Pine Blvd', 'David', 'Brown', '555-5555'),
        (5, '777 Cedar Ln', 'Sarah', 'Jones', '555-6666'),
        (6, '888 Birch Dr', 'Matthew', 'Miller', '555-7777'),
        (7, '999 Walnut St', 'Jennifer', 'Taylor', '555-8888'),
        (8, '111 Willow Ave', 'Daniel', 'Anderson', '555-9999'),
        (9, '222 Redwood Rd', 'Jessica', 'Thomas', '555-1010'),
        (10, '333 Spruce Ct', 'Christopher', 'Lee', '555-1112'),
        (11, '444 Birch Ln', 'Laura', 'Garcia', '555-1213'),
        (12, '555 Oak Blvd', 'James', 'Martinez', '555-1314'),
        (13, '666 Elm Rd', 'Amanda', 'Robinson', '555-1415'),
        (14, '777 Cedar Ave', 'Robert', 'Clark', '555-1516'),
        (15, '888 Pine Ct', 'Melissa', 'Lewis', '555-1617'),
        (16, '999 Maple Ln', 'William', 'Hill', '555-1718'),
        (17, '111 Birch Dr', 'Michelle', 'Lopez', '555-1819'),
        (18, '222 Elm St', 'Elizabeth', 'Green', '555-1920'),
        (19, '333 Oak Ave', 'Andrew', 'Adams', '555-2021'),
        (20, 'Hauptstraße 1', 'Oliver', 'Schmidt', '555-3030'),
        (21, 'Bahnhofstraße 15', 'Sophie', 'Müller', '555-4040'),
        (22, 'Kirchplatz 8', 'Lukas', 'Fischer', '555-5050');
insert into borrowing_records (id, borrow_date, remarks, return_date, book_id, member_id)
values  (1, '2019-11-30', 'Late return, fine applied as per library policy.', '2022-09-02', 7, 1),
        (2, '2019-11-28', 'Member requested book recommendation, provided suggestion.', '2022-11-10', 5, 6),
        (3, '2020-05-27', 'Member requested book renewal, granted for one week.', '2022-08-11', 5, 6),
        (4, '2020-09-16', 'Out of stock, reservation placed for next available copy.', '2023-03-14', 8, 3),
        (5, '2020-10-08', 'Not returned, follow up with member required.', '2023-04-17', 6, 21),
        (6, '2021-03-28', 'Inter-library loan initiated for unavailable book.', '2023-01-11', 5, 2),
        (7, '2019-08-29', 'Book reserved, notify member when available.', '2022-08-16', 8, 5),
        (8, '2020-07-10', 'Extended borrowing period approved by librarian.', '2023-07-18', 5, 14),
        (9, '2019-11-04', 'Returned with minor damage, to be repaired.', '2023-06-02', 1, 19),
        (10, '2021-02-24', 'Extended borrowing period approved by librarian.', '2022-08-30', 4, 4),
        (11, '2019-09-10', 'Member provided student ID for verification.', '2023-01-07', 6, 1);
