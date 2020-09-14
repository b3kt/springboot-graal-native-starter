CREATE TABLE customer(
    id INTEGER PRIMARY KEY,
    first_name VARCHAR DEFAULT NULL,
    last_name VARCHAR DEFAULT NULL
);

CREATE TABLE product(
    id INTEGER PRIMARY KEY,
    name VARCHAR DEFAULT NULL,
    price VARCHAR DEFAULT NULL    
);

CREATE TABLE orders(
    id INTEGER PRIMARY KEY,
    customer_id INTEGER,
    product_id INTEGER,
    qty INTEGER
);

