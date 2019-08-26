import java.sql.*;

public class DatabaseConnection {
 /**
  * Create database connection using JDBC driver
  * 
  * @return returns connection Instance
  */
 public static Connection getConnection() {
  System.out.println("HEllo Woled");
  Connection connection = null;
  try {
   // register JDBC Driver
   Class.forName("com.mysql.jdbc.Driver");
   String url = "jdbc:mysql://localhost/storefront2";
   String userName = "root";
   String password = "root";
   // opens connection
   connection = DriverManager.getConnection(url, userName, password);

  } catch (ClassNotFoundException classNotFoundException) {
   classNotFoundException.printStackTrace();
  } catch (SQLException sqlException) {
   sqlException.printStackTrace();

  }
  return connection;
 }
}
