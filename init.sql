CREATE TABLE IF NOT EXISTS books (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL,
                       isbn VARCHAR(13) NOT NULL UNIQUE,
                       published_date DATE,
                       available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS clients (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         phone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS reservations (
                              id SERIAL PRIMARY KEY,
                              book_id INT REFERENCES books(id),
                              client_id INT REFERENCES clients(id),
                              reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              status VARCHAR(50) DEFAULT 'active'
);
