package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is a component class. This class provides connection from the database
 * 
 * @author Naman
 */
public class SQLConnection {

    // Reference variables.
    private static Connection connection;

    /**
     * This method returns Connection class object.
     * 
     * @return Connection class object
     */
    public static Connection getConnection(String dbName) {
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
