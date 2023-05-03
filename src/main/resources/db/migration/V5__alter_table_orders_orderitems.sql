ALTER TABLE orders ADD COLUMN is_paid boolean DEFAULT false;
ALTER TABLE order_items DROP COLUMN is_paid;