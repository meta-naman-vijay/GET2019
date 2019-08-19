/* query1 */
select orderId,order_date,total_price from orders ORDER BY order_date DESC LIMIT 50;

/* query2 */
select * from orders ORDER BY total_price DESC LIMIT 10;

/* query3 */
select * from orders where order_date < DATE_SUB(NOW(), INTERVAL 10 DAY);

/* query4 */
select user.userId, userName.first_name,user.email_id 
from user,userName,orders 
WHERE user.userType='shopper' AND user.userId=userName.userId 
AND orders.userId=user.userId AND orders.orderId NOT IN(SELECT DISTINCT orders.orderId
FROM orders WHERE MONTH(orders.order_date) >= (MONTH(NOW())-1) AND YEAR(orders.order_date) = YEAR(NOW()));

/* query5 */
select user.userId, userName.first_name,user.email_id 
from user,userName,orders 
WHERE user.userType='shopper' AND user.userId=userName.userId 
AND orders.userId=user.userId AND orders.orderId IN
(SELECT DISTINCT orders.orderId FROM orders WHERE orders.order_date > DATE_SUB(NOW(), INTERVAL 15 DAY));

/* query6 */
 select product.product_name from product,orders,status where product.productId=orders.productId AND 
 orders.orderId=status.orderId AND orders.orderId=2 AND status.shipped='y';
 
 /* query7 */
 SELECT product.product_name, orders.order_date FROM product
 JOIN orders ON product.productId=orders.productId 
 WHERE product.price BETWEEN 20 AND 50;