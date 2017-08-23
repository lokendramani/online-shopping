CREATE TABLE CATEGORY(
 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 
 CONSTRAINT pk_category_id PRIMARY KEY (id)
);


CREATE TABLE user_detail(
id IDENTITY,
first_name varchar(50),
last_name varchar(50),
role varchar(50),
enabled BOOLEAN,
password varchar(50),
email varchar(50),
contact_number VARCHAR(15)

CONSTRAINT pk_user_id PRIMARY KEY(id)

);

insert into user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES
('Lokendra','Mani','ADMIN',true,'admin','lokendramani@gmail.com','9818469891');

insert into user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES
('Vayu','Raghavan','SUPPLIER',true,'12345','vayu@gmail.com','8956231478');

insert into user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES
('Phulela','Gopichand','SUPPLIER',true,'12345','ph@gmail.com','1234567890');

CREATE TABLE PRODUCT(
ID IDENTITY,
CODE VARCHAR(20),
NAME VARCHAR(50),
BRAND VARCHAR(50),
DESCRIPTION VARCHAR(255),
UNIT_PRICE DECIMAL(10,2),
QUANTITY INT,
IS_ACTIVE BOOLEAN,
CATEGORY_ID INT,
SUPPLIER_ID INT,
PURCHASES INT DEFAULT 0,
VIEWS INT DEFAULT 0,

CONSTRAINT PK_PRODUCT_ID PRIMARY KEY (ID),
CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(ID),
CONSTRAINT FK_PRODUCT_SUPPLIER_ID FOREIGN KEY (SUPPLIER_ID) REFERENCES USER_DETAIL(ID),
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3 );