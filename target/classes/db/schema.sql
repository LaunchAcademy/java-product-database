DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  price DECIMAL NOT NULL,
  featured BOOLEAN,
  category_name VARCHAR(255)
);