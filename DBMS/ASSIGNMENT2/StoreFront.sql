CREATE DATABASE StoreFront2;
use StoreFront2;

create table user(
    userId INT AUTO_INCREMENT PRIMARY KEY,
    email_id VARCHAR(25) NOT NULL,
    password VARCHAR(20) NOT NULL,
    dob DATE,
    gender CHAR(1),
    userType CHAR(7)
);
    
create table userName(
    userId INT,
    first_name varchar(20) NOT NULL,
    middle_name varchar(20),
    last_name varchar(20), 
    FOREIGN KEY(userId) REFERENCES user(userId)
);

create table contactNumber(
    userId INT NOT NULL,
    contact_number DOUBLE NOT NULL,
    FOREIGN KEY(userId) REFERENCES user(userId)
);

CREATE TABLE userAddress(
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    userId INT NOT NULL,
    street VARCHAR(20),
    city VARCHAR(15),
    state VARCHAR(15),
    pin_code INT,
    FOREIGN KEY(userId) REFERENCES user(userId)
);
    
CREATE TABLE product(
    productId INT PRIMARY KEY AUTO_INCREMENT,
    price INT NOT NULL,
    product_name VARCHAR(20),
    stock INT NOT NULL,
    categoryId INT,
    description VARCHAR(100),
    FOREIGN KEY(categoryId) REFERENCES category(categoryId)
);

CREATE TABLE product_images(
    productId int NOT NULL,
    image_url varchar(100) DEFAULT NULL,
    foreign key(productId) references product(productId)
);

CREATE TABLE category(
    categoryId INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(20),
    parentId INT,
    FOREIGN KEY(parentId) REFERENCES category(categoryId)
);

CREATE TABLE cart(
    productId INT,
    userId INT,
    quantity INT NOT NULL,
    total_price DOUBLE DEFAULT 0,
    FOREIGN KEY(productId) REFERENCES product(productId),
    FOREIGN KEY(userId) REFERENCES user(userId)
);
    

CREATE TABLE orders(
    orderId INT NOT NULL auto_increment,
    address_id INT,
    order_date DATE,
    delivery_date DATE,
    total_price DOUBLE NOT NULL,
    userId INT,
    productId INT,
    PRIMARY KEY(orderId),
    FOREIGN KEY(address_id) REFERENCES userAddress(address_id),
    FOREIGN KEY(userId) REFERENCES user(userId),
    FOREIGN KEY(productId) REFERENCES product(productId)
);
    
    

create table status(
    orderId int ,
    productId int,
    delevered char(1),
    returned char(1),
    canceled char(1),
    shipped char(1),
    foreign key(orderId) references orders(orderId),
    foreign key(productId) references product(productId)
);



SHOW tables;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE PRODUCT;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE product(
    productId INT PRIMARY KEY AUTO_INCREMENT,
    price INT NOT NULL,
    product_name VARCHAR(20),
    stock INT NOT NULL,
    categoryId INT,
    description VARCHAR(100),
    FOREIGN KEY(categoryId) REFERENCES category(categoryId)
);






