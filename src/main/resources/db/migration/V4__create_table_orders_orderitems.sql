CREATE TYPE status AS ENUM (
    'PENDING',
    'CONFIRMED',
    'IN_TRANSIT',
    'DELIVERED',
    'CANCELLED',
    'REFUNDED'
);

CREATE DOMAIN status_domain AS varchar(255);
CREATE CAST (status_domain AS status) WITH INOUT AS IMPLICIT;

CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        status status_domain NOT NULL,
                        customer_id BIGINT NOT NULL,
                        store_id BIGINT NOT NULL,
                        total_price NUMERIC(10, 2) NOT NULL,
                        date_time TIMESTAMP NOT NULL,
                        FOREIGN KEY (customer_id) REFERENCES customers(id),
                        FOREIGN KEY (store_id) REFERENCES stores(id)
);

CREATE TABLE order_items (
                             id SERIAL PRIMARY KEY,
                             order_id BIGINT REFERENCES orders(id),
                             name VARCHAR(255),
                             price NUMERIC(10,2)
);

