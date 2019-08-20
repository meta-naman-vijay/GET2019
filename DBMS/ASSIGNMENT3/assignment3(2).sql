/* ASSIGNMENT2 */
/* query1 */
select product.productId,product.product_name,COUNT(category.categoryId) as catcount 
from product INNER JOIN category ON product.categoryId=category.categoryId 
GROUP BY category.parentId HAVING Count(catcount) > 1;

/* query2 */
SELECT '0 - 100' as 'Range in Rs', count(product.productid) AS Count FROM product WHERE product.price BETWEEN 0 AND 100
UNION
SELECT '101 - 500' as 'Range in Rs', count(product.productId) AS Count FROM product WHERE product.price BETWEEN 101 AND 500
UNION
SELECT 'Above 500' as 'Range in Rs', count(product.productId) AS Count FROM product WHERE product.price > 500;


/* query3 */
SELECT pc.productId,pc.product_name,COUNT(*) AS product_count
FROM category c INNER JOIN product pc ON c.categoryId=pc.categoryid
GROUP BY pc.categoryId;




/* ASSSIGNMENT3 */
/* query1 */

SELECT userName.first_name,COUNT(*) FROM user,userName,orders where user.
userId = userName.userId AND user.userId=orders.userId AND DATEDIFF(CURDATE(),orders.order_date)<=30 GROUP BY user.userId;

/*query2 */ 
SELECT userName.first_name 
from userName INNER JOIN orders ON userName.userId=orders.userId  
WHERE DATEDIFF(CURDATE(),orders.order_date)<=30
ORDER BY SUM(orders.total_price) DESC LIMIT 10;

/*query3 */
select product.product_name,COUNT(orders.productId) 
from product INNER JOIN orders ON product.productId=orders.productId
WHERE DATEDIFF(CURDATE(),orders.order_date)<=60
GROUP BY product.productId 
DESC LIMIT 20;

/*query4 */
select MONTH(orders.order_date) AS month,SUM(total_price) AS sales_revenue
FROM  orders WHERE TIMESTAMPDIFF(MONTH,order_date,CURDATE())<=6  
GROUP BY month;

/*query5 */
UPDATE product JOIN orders ON product.productId=orders.productId  
SET product.status='inactive' where DATEDIFF(CURDATE(),orders.order_date) >=90 ;

/*query6 */
SELECT product.productId,product.product_name AS "Product Title",
      count(status.productId) AS CancelTimes,
      status.canceled
      FROM product INNER JOIN status
      ON status.productId=product.productId 
      GROUP BY status.productId HAVING status.canceled='y'
      ORDER BY CancelTimes DESC LIMIT 10;

/*query7 */
/* Category must be Parent */ 
SELECT product.productId AS ID,
      product.product_name AS Title
      FROM product WHERE product.categoryId IN(
          SELECT categoryId AS ID FROM category 
          WHERE parentId = (SELECT categoryid 
          FROM category WHERE category_name='electronics')
      );

/* ASSSIGNMENT4 */

CREATE TABLE zipcode
(
    zipcode INT NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    PRIMARY KEY(zipcode)
);

INSERT INTO zipcode VALUES
(313001, 'Udaipur', 'Rajasthan'),
(302019, 'Jaipur', 'Rajasthan'),
(302020, 'Jaipur', 'Rajasthan'), 
(302021, 'Jaipur', 'Rajasthan');

SELECT zipcode, city, state
FROM zipcode
ORDER BY state, city;




/* ASSSIGNMENT5 */
select product_name pn from orderInformation GROUP BY productId ORDER BY
pn DESC LIMIT 5;

CREATE view orderInformation As 
select orders.orderId,product.productId,product.product_name,orders.total_price,userName.first_name,user.email_id,orders.
order_date,product.status from orders JOIN product ON orders.productId=product.productId 
JOIN user ON user.userId=orders.userId JOIN userName ON user.userId=userName.userId 
where orders.order_date > DATE_SUB(CURDATE(),INTERVAL 60 DAY) ORDER
BY orders.orderId DESC;
 
select * from orderInformation;
 
 
select product_name from orderInformation where shipped='y';

 