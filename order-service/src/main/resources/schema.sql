CREATE TABLE IF NOT EXISTS orders(
    id integer NOT NULL,
    user_Id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL,
    order_total numeric NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);