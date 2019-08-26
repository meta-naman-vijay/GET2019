import java.util.*;
import java.sql.*;
import java.sql.Date;

public class DatabaseHelper {
 public static List<orderDetail> getOrderDetails(int userId) {
  List<orderDetail> listOfOrders = new ArrayList<orderDetail>();
  String query = Query.getOrderDetailQuery(userId);
  Connection connection = DatabaseConnection.getConnection();
  try {

   // Allocate statement object in connection
   PreparedStatement statement = connection.prepareStatement(query);
   // execute select query and returns result set
   ResultSet rset = statement.executeQuery();
   while (rset.next()) {
    int orderId = rset.getInt("orderId");
    int productId = rset.getInt("productId");
    Date orderDate = rset.getDate("order_date");
    double orderTotal = rset.getDouble("total_price");
    orderDetail orderDetail = new orderDetail();
    orderDetail.setOrderId(orderId);
    orderDetail.setProductId(productId);
    orderDetail.setOrderDate(orderDate);
    orderDetail.setOrderTotal(orderTotal);
    listOfOrders.add(orderDetail);
   }

  } catch (SQLException sqlException) {
   sqlException.printStackTrace();
  }

  return listOfOrders;
 }

 /**
  * This method is used to execute query to insert images for products.
  * 
  * @param listOfImage
  */
 public static void insertImage(List<ProductImage> listOfImage) {
  String query = Query.getInsertImageQuery();
  try (Connection connection = DatabaseConnection.getConnection();
    // Allocate statement object in connection
    PreparedStatement statement = connection.prepareStatement(query);) {
   try {
    statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
    connection.setAutoCommit(false);
    for (ProductImage image : listOfImage) {
     statement.setInt(1, image.getProductId());
     statement.setInt(2, image.getImageId());
     statement.setString(3, image.getImageUrl());
     statement.setString(4, image.getImageTag());
     statement.addBatch();
    }
    // multiple rows are inserted using batch insert technique
    statement.executeBatch();
    connection.commit();
    statement.executeQuery("SET FOREIGN_KEY_CHECKS=1");
   } catch (SQLException sqlException) {
    sqlException.printStackTrace();
    connection.rollback();
   }
  } catch (SQLException exception) {
   exception.printStackTrace();
  }
 }

 /**
  * This method is used to execute query to mark inactive status for all products
  * which were not ordered by any Shopper in last 1 year.
  * 
  * @return
  */
 public static int updateProductStatus() {
  int updatedRows = 0;
  String query = Query.getUpdateProductStatusQuery();
  try (Connection connection = DatabaseConnection.getConnection();
    // Allocate statement object in connection
    PreparedStatement statement = connection.prepareStatement(query);) {
   statement.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
   // execute update query and return updated rows
   updatedRows = statement.executeUpdate();
   statement.executeUpdate("SET FOREIGN_KEY_CHECKS=1");
  } catch (SQLException sqlException) {
   sqlException.printStackTrace();
  }
  return updatedRows;
 }

 /**
  * This method is used to execute query to get top category details with their
  * child count.
  * 
  * @return
  */
 public static List<TopCategoryDetail> getTopCategoryDetails() {
  List<TopCategoryDetail> listOfTopCategoryDetail = new ArrayList<TopCategoryDetail>();
  String query = Query.getTopCategoryDetails();
  try (Connection connection = DatabaseConnection.getConnection();
    // Allocate statement object in connection
    PreparedStatement statement = connection.prepareStatement(query);) {
   // execute select query and returns result set
  
   ResultSet rset = statement.executeQuery();
      while (rset.next()) {

    String category_name = rset.getString("category_name");
    int numberOfChildren = rset.getInt("numberOfChildren");
    TopCategoryDetail topCategoryDetail = new TopCategoryDetail();
    topCategoryDetail.setName(category_name);
    topCategoryDetail.setNumberOfChildren(numberOfChildren);
    listOfTopCategoryDetail.add(topCategoryDetail);
   }

  } catch (SQLException sqlException) {
   sqlException.printStackTrace();
  }
  return listOfTopCategoryDetail;
 }
}
