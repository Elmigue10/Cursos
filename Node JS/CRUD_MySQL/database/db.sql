CREATE DATABASE crud;
use crud;

CREATE TABLE customer (
    id int (10) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR (30) NOT NULL, 
    address VARCHAR (50) NOT NULL,
    phone VARCHAR (10)
);
