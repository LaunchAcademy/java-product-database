DROP TABLE IF EXISTS products;
CREATE TABLE products(
    id SERIAL PRIMARY KEY,
    name VARCHAR(55) NOT NULLABLE,
    description TEXT,
    price DOUBLE PRECISION,
    feature BOOLEAN,
    category_name VARCHAR(55)
);