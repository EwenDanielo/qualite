CREATE TABLE IF NOT EXISTS book (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       isbn VARCHAR(13) NOT NULL UNIQUE,
                       published_date DATE,
                       available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS client (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         phone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS reservation (
                              id SERIAL PRIMARY KEY,
                              book_id INT REFERENCES books(id),
                              client_id INT REFERENCES clients(id),
                              reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              status VARCHAR(50) DEFAULT 'active'
);


INSERT INTO book (title, author, isbn, published_date, available) VALUES
                                                                      ('1984', 'George Orwell', '9780451524935', '1949-06-08', true),
                                                                      ('Le Petit Prince', 'Antoine de Saint-Exupéry', '9780156013987', '1943-04-06', true),
                                                                      ('L’Étranger', 'Albert Camus', '9782070360024', '1942-05-01', false),
                                                                      ('To Kill a Mockingbird', 'Harper Lee', '9780061120084', '1960-07-11', true),
                                                                      ('The Hobbit', 'J.R.R. Tolkien', '9780547928227', '1937-09-21', false),
                                                                      ('Pride and Prejudice', 'Jane Austen', '9780141439518', '1813-01-28', true),
                                                                      ('Les Misérables', 'Victor Hugo', '9782070409181', '1862-06-30', true),
                                                                      ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', '1925-04-10', true),
                                                                      ('Don Quixote', 'Miguel de Cervantes', '9780060934347', '1605-01-16', false),
                                                                      ('Harry Potter 1', 'J.K. Rowling', '9780747532699', '1997-06-26', true);

INSERT INTO client (first_name, last_name, email, phone) VALUES
                                                             ('Alice', 'Martin', 'alice.martin@example.com', '0612345678'),
                                                             ('Bob', 'Durand', 'bob.durand@example.com', '0698765432'),
                                                             ('Claire', 'Lemoine', 'claire.lemoine@example.com', '0678123456'),
                                                             ('David', 'Bernard', 'david.bernard@example.com', '0601020304'),
                                                             ('Emma', 'Petit', 'emma.petit@example.com', '0623456789'),
                                                             ('François', 'Morel', 'francois.morel@example.com', '0654321987'),
                                                             ('Gwen', 'Roux', 'gwen.roux@example.com', '0643217890'),
                                                             ('Hugo', 'Fabre', 'hugo.fabre@example.com', '0634567890'),
                                                             ('Isabelle', 'Renard', 'isabelle.renard@example.com', '0678901234'),
                                                             ('Julien', 'Barbier', 'julien.barbier@example.com', '0611223344');

INSERT INTO reservation (book_id, client_id, reservation_date, status) VALUES
                                                                           (1, 1, '2025-06-01 10:00:00', 'active'),
                                                                           (2, 3, '2025-06-02 14:30:00', 'active'),
                                                                           (3, 2, '2025-06-03 09:15:00', 'cancelled'),
                                                                           (4, 4, '2025-06-04 11:00:00', 'active'),
                                                                           (5, 6, '2025-06-05 13:45:00', 'returned'),
                                                                           (6, 5, '2025-06-06 08:00:00', 'active'),
                                                                           (7, 7, '2025-06-07 17:30:00', 'active'),
                                                                           (8, 8, '2025-06-08 15:00:00', 'cancelled'),
                                                                           (9, 9, '2025-06-09 12:00:00', 'returned'),
                                                                           (10, 10, '2025-06-10 10:30:00', 'active');
