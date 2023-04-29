CREATE TABLE stores (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        category VARCHAR(255) NOT NULL,
                        closing_days VARCHAR(255) NOT NULL,
                        opening_hours TIME NOT NULL,
                        closing_hours TIME NOT NULL
);

CREATE TABLE items (
                       id SERIAL PRIMARY KEY,
                       store_id BIGINT NOT NULL REFERENCES stores(id),
                       name VARCHAR(255) NOT NULL,
                       price NUMERIC(10, 2) NOT NULL,
                       category VARCHAR(255) NOT NULL
);
