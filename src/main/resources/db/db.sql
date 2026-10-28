
CREATE DATABASE IF NOT EXISTS Tiendadb;


CREATE TABLE Tiendadb.products (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    product_code VARCHAR(255),
    product_description VARCHAR(255),
    product_price DOUBLE
);


CREATE TABLE Tiendadb.accounts (

    account_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_name VARCHAR(255),
    account_email VARCHAR(255),
    account_address VARCHAR(255)
);

CREATE TABLE Tiendadb.wishlists (
    account_id BIGINT,
    product_id BIGINT,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id),
    PRIMARY KEY (account_id, product_id)
);

CREATE TABLE Tiendadb.orders (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_id BIGINT,
    order_date DATE DEFAULT (CURRENT_DATE),
    status VARCHAR(50),
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

CREATE TABLE Tiendadb.order_items (
    order_item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    product_id BIGINT,
    quantity INT,
    unit_price DOUBLE,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE Tiendadb.invoices (
    invoice_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT UNIQUE,
    invoice_date DATE DEFAULT (CURRENT_DATE),
    total_amount DOUBLE,
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
);
