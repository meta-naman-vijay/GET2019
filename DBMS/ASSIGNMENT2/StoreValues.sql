/* query1 */
INSERT INTO user VALUES(1,'namanvijay1997@gmail.com','hello123','1997-09-09','m','admin');

INSERT INTO user VALUES(2,'nkv@gmail.com','hello123','1997-04-09','m','shopper');

INSERT INTO user VALUES(3,'krishanprajapat@gmail.com','hello1234','1997-09-05','m','shopper');

INSERT INTO user VALUES(4,'pandeyji@gmail.com','pandey','1998-04-06','f','shopper');

INSERT INTO user VALUES(5,'aman1790@gmail.com','hello123','1997-04-09','m','shopper');



INSERT INTO userName(userid,first_name,middle_name,last_name) VALUES(1,'Naman','Kumar','vijay');

INSERT INTO userName(userid,first_name,last_name) VALUES(2,'Naman','vijay');

INSERT INTO userName(userid,first_name,middle_name,last_name) VALUES(3,'krishan','Kumar','prajapat');

INSERT INTO userName(userid,first_name,last_name) VALUES(4,'priya','pandey');

INSERT INTO userName(userid,first_name,middle_name,last_name) VALUES(5,'aman','Kumar','vijay');



INSERT INTO contactNumber(userid,contact_number) VALUES(1,9799475865);

INSERT INTO contactNumber(userid,contact_number) VALUES(2,9745675865);

INSERT INTO contactNumber(userid,contact_number) VALUES(3,8999475865);

INSERT INTO contactNumber(userid,contact_number) VALUES(4,7877363371);

INSERT INTO contactNumber(userid,contact_number) VALUES(5,9783430470);



INSERT INTO userAddress(address_id,userid,street,city,state,pin_code) VALUES(1,1,'456 surya nagar','JAipur', 'rajasthan',302015);

INSERT INTO userAddress(address_id,userid,street,city,state,pin_code) VALUES(2,2,'457 surya nagar','udaipur', 'rajasthan',202015);

INSERT INTO userAddress(address_id,userid,street,city,state,pin_code) VALUES(3,3,'700 kumbha marg','JAipur', 'rajasthan',407015);

INSERT INTO userAddress(address_id,userid,street,city,state,pin_code) VALUES(4,3,'65-A surya nagar','mount abu', 'rajasthan',305014);

INSERT INTO userAddress(address_id,userid,street,city,state,pin_code) VALUES(5,5,'aroli nagar','srinagar', 'J&K',205078);



INSERT INTO product(price,product_name,stock,categoryId,description) values(200,'hat',10,2,'Helo World. This is Hat');

INSERT INTO product(price,product_name,stock,categoryId,description) values(250,'bat',8,5,'Hello World. This is Bat');

INSERT INTO product(price,product_name,stock,categoryId,description) values(2000,'razer',1,7,'Helo World. This is Razer');

INSERT INTO product(price,product_name,stock,categoryId,description) values(350,'tshirt',101,3,'Helo World. This is Tshirt');

INSERT INTO product(price,product_name,stock,categoryId,description) values(1250,'cooker',10,8,'Helo World. This is Cooker');

INSERT INTO product(price,product_name,stock,categoryId,description) values(1000,'sports',100,NULL,'Helo World. This is sports');



INSERT INTO product_images values(1,'D:\thepathofimage.jpg');

INSERT INTO product_images values(2,'D:\theotherimage.jpg');

INSERT INTO product_images values(3,'D:\image1.jpg');

INSERT INTO product_images values(4,'D:\newfile.png');

INSERT INTO product_images values(5,'D:\thepathofimage1.png');

INSERT INTO product_images values(6,'');



INSERT INTO CATEGORY(categoryId,category_name,parentId) values(1,'clothes',NULL);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(2,'hat',1);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(3,'tshirt',1);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(4,'sports',NULL);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(5,'bat',4);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(6,'electronics',NULL);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(7,'razer',6);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(8,'cooker',6);

INSERT INTO CATEGORY(categoryId,category_name,parentId) values(9,'cooker',4);



INSERT INTO cart(productId,userId,quantity,total_price) VALUES(1,1,2,400);

INSERT INTO cart(productId,userId,quantity,total_price) VALUES(2,1,3,1150);

INSERT INTO cart(productId,userId,quantity,total_price) VALUES(3,2,2,4000);

INSERT INTO cart(productId,userId,quantity,total_price) VALUES(1,3,2,400);

INSERT INTO cart(productId,userId,quantity,total_price) VALUES(5,3,10,12900);



INSERT INTO orders(orderId,address_id,order_date,total_price,userId,productId) values(1,1,'2018-12-12',1150,1,1);

INSERT INTO orders(orderId,address_id,order_date,total_price,userId,productId) values(2,1,'2018-12-12',4000,2,2);

INSERT INTO orders(orderId,address_id,order_date,total_price,userId,productId) values(3,2,'2019-11-09',12900,3,3);

INSERT INTO orders(orderId,address_id,order_date,total_price,userId,productId) values(6,3,'2019-08-08',1290,3,4);


INSERT INTO status(orderId,productId,delevered,returned,canceled,shipped) values(1,2,'y','n','n','y');

INSERT INTO status(orderId,productId,delevered,returned,canceled,shipped) values(2,3,'y','y','n','y');

INSERT INTO status(orderId,productId,delevered,returned,canceled,shipped) values(3,5,'n','n','y','y');



/* query2 */
select product.productId, product.product_name,category.category_name,product.price from product JOIN category ON 
product.categoryId=category.categoryId where product.stock>0 ORDER BY product.productId DESC LIMIT 10;




/* query3 */ 
SELECT product_name
FROM product
WHERE productId NOT IN (SELECT productId FROM product_images);

/* query4 */
SELECT Cat.categoryId, Cat.category_name as Title, IF(Parent.category_name IS NULL, 'TOP CATEGORY', Parent.category_name) as 'Parent Category Title'
FROM category Cat LEFT JOIN category Parent
ON Cat.parentId = Parent.categoryId
ORDER BY Parent.category_name, Cat.category_name ASC;

/* query5 */
SELECT Cat.categoryId, Cat.category_name as Title, IF(Parent.category_name IS NULL, 'TOP CATEGORY', Parent.category_name) as 'Parent Category Title'
FROM category Cat LEFT JOIN category Parent
ON Cat.parentId = Parent.categoryId
where Cat.categoryId NOT IN (SELECT DISTINCT(parentId) FROM category where parentId IS NOT NULL);

/* query6 */
SELECT p.product_name,p.price,p.description 
FROM product p JOIN category c ON c.categoryId=p.categoryId 
WHERE c.categoryId=(SELECT categoryId from product where product_name='hat');

/* query7 */
SELECT product_name FROM product WHERE stock<50;



