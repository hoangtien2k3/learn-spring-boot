CREATE DATABASE mydb;

USE mydb;

CREATE TABLE tbl_laptops(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    price DOUBLE(10, 2) NOT NULL,
    created_at DATE NOT NULL
);

INSERT INTO tbl_laptops(name, description, brand, price, created_at)
VALUES("Dell Inspiron", "dell company laptop", "Dell", 60000.00, '2021-02-10');
INSERT INTO tbl_laptops(name, description, brand, price, created_at)
VALUES("Dell XPS", "dell company laptop", "Dell", 70000.00, '2020-12-31');
INSERT INTO tbl_laptops(name, description, brand, price, created_at)
VALUES("Macbook Air", "apple company laptop", "Apple", 85000.00, '2021-01-31');
INSERT INTO tbl_laptops(name, description, brand, price, created_at)
VALUES("Macbook Pro", "apple company laptop", "Apple", 160000.00, '2021-12-25');
INSERT INTO tbl_laptops(name, description, brand, price, created_at)
VALUES("HP", "hp company laptop", "HP", 50000.00, '2021-02-10');
INSERT INTO tbl_laptops(name, description, brand, price, created_at)
VALUES("Lenovo", "lenovo company laptop", "Lenovo", 50000.00, '2020-11-21');

SELECT * FROM tbl_laptops;