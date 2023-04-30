CREATE TYPE dayofweek AS ENUM ('MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY', 'SUNDAY');

CREATE TYPE store_category AS ENUM ('SUPERMARKET', 'GROCERY_STORE', 'CONVENIENCE_STORE', 'PIZZERIA', 'FAST_FOOD', 'BURGUER_JOINT', 'JAPANESE_RESTAURANT', 'STEAKHOUSE');

CREATE TYPE category_type AS ENUM ('PIZZA', 'BURGUER', 'SANDWICH', 'DESSERT', 'DRINK', 'JAPANESE_FOOD', 'PASTA', 'CHICKEN', 'SALAD', 'TACO', 'SEAFOOD');

CREATE TABLE stores (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        category store_category NOT NULL,
                        closing_days dayofweek[],
                        opening_hours TIME NOT NULL,
                        closing_hours TIME NOT NULL
);

CREATE TABLE items (
                       id SERIAL PRIMARY KEY,
                       store_id BIGINT NOT NULL REFERENCES stores(id),
                       name VARCHAR(255) NOT NULL,
                       price NUMERIC(10, 2) NOT NULL,
                       category category_type NOT NULL
);
