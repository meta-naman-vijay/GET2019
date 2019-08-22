/* ASSIGNEMNT-1(1) */

DROP FUNCTION IF EXISTS get_number_of_orders;
DELIMITER $$
CREATE FUNCTION get_number_of_orders(input_month INT,input_year INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE number_of_orders INT;
    
    SELECT COUNT(*) INTO number_of_orders 
    FROM orders 
    WHERE MONTH(order_date) IN(input_month)  AND YEAR(order_date) IN(input_year);
    
    RETURN(number_of_orders);
END$$
DELIMITER ;

SELECT get_number_of_orders(8,2019);

   
   
/* ASSIGNEMNT-1(2) */

DROP FUNCTION most_ordered_month;
DELIMITER $$
CREATE FUNCTION  most_ordered_month(input_year INT)
    RETURNS VARCHAR(10)
    DETERMINISTIC
BEGIN
    DECLARE best_month VARCHAR(9);
    SELECT MONTHNAME(order_date) INTO best_month
    FROM orders 
    WHERE YEAR(order_date) IN(input_year)
    GROUP BY MONTH(order_date)
    ORDER BY COUNT(*) DESC
    LIMIT 1;
    RETURN(best_month);
END $$

DELIMITER ;
SELECT most_ordered_month(2018);


   
/* ASSIGNEMNT-2(1) */
DROP PROCEDURE IF EXISTS get_average_sale;
DELIMITER $$
CREATE PROCEDURE get_average_sale(input_month INT, input_year INT)
BEGIN
    SELECT product.product_name,COUNT(product.productId) AS avg_sale
    FROM orders
    JOIN product ON orders.productId=product.productId
    WHERE MONTH(orders.order_date)=input_month AND YEAR(orders.order_date)=input_year
    GROUP BY orders.productId;
END$$
DELIMITER ;


CALL get_average_sale(12,2018);
use storefront2;

    
/* ASSIGNEMNT-2(2) */
DROP PROCEDURE IF EXISTS get_order_detail;
DELIMITER $$
CREATE PROCEDURE get_order_detail(start_date DATE, end_date DATE)
BEGIN
    IF start_date>end_date THEN 
        SET start_date=end_date-Interval day(end_date) DAY;
    END IF;
    SELECT orders.orderId,orders.order_date,orders.total_price,
    orders.productId,status.shipped AS Shipped,status.delevered AS Delivered 
    FROM orders JOIN status ON orders.orderId = status.orderId 
    WHERE orders.order_date>=start_date AND orders.order_date<=end_date;
END$$
DELIMITER ;

CALL get_order_detail('2018-07-06',CURDATE());


/* ASSIGNEMNT-3 */
ALTER TABLE product ADD INDEX product (productId);
ALTER TABLE category ADD INDEX parent_category_id (category_name);
ALTER TABLE orders ADD INDEX odrder_index (order_date);

