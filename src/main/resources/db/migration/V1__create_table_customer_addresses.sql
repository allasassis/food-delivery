CREATE TABLE customers (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255),
                           last_name VARCHAR(255),
                           email VARCHAR(255),
                           cellphone VARCHAR(20),
                           address_id BIGINT,
                           birth_date DATE,
                           creation_date DATE
);

CREATE TABLE addresses (
                           id SERIAL PRIMARY KEY,
                           customer_id BIGINT UNIQUE,
                           street VARCHAR(255),
                           complement VARCHAR(255),
                           number INTEGER,
                           neighborhood VARCHAR(255),
                           city VARCHAR(255),
                           state VARCHAR(255),
                           country VARCHAR(255),
                           zipcode VARCHAR(20)
);

ALTER TABLE customers ADD CONSTRAINT fk_customer_address FOREIGN KEY (address_id) REFERENCES addresses(id);
ALTER TABLE addresses ADD CONSTRAINT fk_address_customer FOREIGN KEY (customer_id) REFERENCES customers(id);
