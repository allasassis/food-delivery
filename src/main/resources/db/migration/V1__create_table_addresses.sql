CREATE TABLE addresses (
                           id SERIAL PRIMARY KEY,
                           street VARCHAR(255) NOT NULL,
                           complement VARCHAR(255),
                           number INTEGER NOT NULL,
                           neighborhood VARCHAR(255) NOT NULL,
                           city VARCHAR(255) NOT NULL,
                           state CHAR(2) NOT NULL,
                           country VARCHAR(255) NOT NULL,
                           zipcode VARCHAR(255) NOT NULL
);

