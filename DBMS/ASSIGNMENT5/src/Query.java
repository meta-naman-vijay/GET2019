import java.sql.*;

public class Query {
 /**
  * Returns query to fetch all order details of a user which are in shipped
  * state. Orders should be sorted by order date column in chronological order.
  * 
  * @param userId contains Id of user whose order to be fetched.
  * @return
  */
 public static String getOrderDetailQuery(int userId) {
  String query = "SELECT distinct orders.orderId,product.productId,orders.order_date,orders.total_price "
    + "FROM orders join user on orders.userId = user.userId JOIN "
    + "status on orders.orderId = status.orderId JOIN product ON product.productId=orders.productId"
    + " WHERE user.userId =" + userId + " AND status.shipped = 'y' order by orders.order_date ASC";

  return query;
 }

 /**
  * Returns query to insert five or more images of a product using batch insert
  * technique.
  * 
  * @return
  */

 public static String getInsertImageQuery() {
  String query = "INSERT INTO product_images(productId,imageId,imageUrl,imageTag) values(?, ?, ?, ?)";
  return query;
 }

 /**
  * Returns query to mark inactive status for all products which were not ordered
  * by any Shopper in last 1 year.
  * 
  * @return
  */
 public static String getUpdateProductStatusQuery() {

  String query = "delete from product " + "where productId IN(select orders.productId from orders "
    + "WHERE TIMESTAMPDIFF(YEAR,orders.order_date,CURDATE())<=1)";
  return query;
 }

 /**
  * Returns query to select the category title of all top parent categories
  * sorted alphabetically and the count of their child categories.
  * 
  * @return
  */
 public static String getTopCategoryDetails() {
  String query = "select c.category_name,COUNT(c.categoryId) AS numberOfChildren "
    + "FROM category c LEFT JOIN category cat ON c.categoryId=cat.parentId WHERE c.parentId is NULL "
    + "GROUP BY c.category_name ORDER BY c.category_name";
  return query;
 }

}