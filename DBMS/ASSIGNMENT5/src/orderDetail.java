import java.sql.*;

/**
 * This class represents Orders of user.
 *
 */
public class orderDetail {
 private int orderId;
 private int productId;
 private Date order_date;
 private double total_price;

 public int getProductId() {
  return productId;
 }

 public void setProductId(int productId) {
  this.productId = productId;
 }

 public int getOrderId() {
  return orderId;
 }

 public void setOrderId(int orderId) {
  this.orderId = orderId;
 }

 public Date getOrderDate() {
  return order_date;
 }

 public void setOrderDate(Date order_date) {
  this.order_date = order_date;
 }

 public double getOrderTotal() {
  return total_price;
 }

 public void setOrderTotal(double orderTotal) {
  this.total_price = total_price;
 }

}
