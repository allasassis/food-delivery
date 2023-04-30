CREATE TABLE customers (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           last_name VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL,
                           cellphone VARCHAR(255) NOT NULL,
                           address_id INTEGER NOT NULL,
                           birth_date DATE NOT NULL,
                           creation_date DATE NOT NULL,
                           FOREIGN KEY (address_id) REFERENCES addresses(id)
);