CREATE TABLE IF NOT EXISTS product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    cost_price DOUBLE NOT NULL,
    selling_price DOUBLE NOT NULL,
    quantity INT NOT NULL
);