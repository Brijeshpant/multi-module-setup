CREATE TABLE IF NOT EXISTS Products
(
    id SERIAL PRIMARY KEY,
    name character varying  NOT NULL UNIQUE,
    category character varying,
    price integer
);
