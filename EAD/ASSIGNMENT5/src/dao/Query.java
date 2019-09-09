package dao;

/**
 * @author Naman This is utility class to store queries.
 */
public class Query {

    /**
     * Method to add product into cart
     * 
     * @return
     */
    public static String getAddProductIntoCartQuery() {
        String query = "INSERT INTO cart(user_id,product_code,quantity)"
                + "VALUES(?,?,?)";
        return query;
    }

    /**
     * Method to add update product in cart
     * 
     * @return
     */
    public static String getUpdateProductIntoCartQuery() {
        String query = "UPDATE Product" + "SET quantity=?"
                + "WHERE user_id=? AND product_id=?";
        return query;
    }

    /**
     * Method to remove product from cart
     * 
     * @return
     */
    public static String getDeleteProductFromCartQuery() {
        String query = "DELETE FROM Product "
                + "WHERE user_id=? AND product_id=?";
        return query;
    }

    /**
     * Method to Fetch user query
     * 
     * @return query
     */
    public static String getListOfUserQuery() {
        String query = "SELECT user_id,user_name,address,contact_number FROM user";
        return query;
    }

    /**
     * Method to Fetch all product query
     * 
     * @return query
     */
    public static String getListOfProductQuery() {
        String query = "SELECT product_code,product_type,product_name,product_price FROM product";
        return query;
    }

    /**
     * Method to Fetch all product in cart for a perticular user query
     * 
     * @return query
     */
    public static String getCartDetailQuery(int userId) {
        String query = "SELECT product_code,quantity FROM cart "
                + "WHERE user_id=" + userId;
        return query;
    }

    public static String updateProductIntoCartQuery(int userId, int productCode) {
        String query = "UPDATE cart  " + "SET quantity=? " + "WHERE user_id="
                + userId + " AND product_code=" + productCode;
        return query;
    }

    public static String removeProductFromCartQuery(int userId, int productCode) {
        String query = "DELETE FROM cart " + "WHERE user_id=" + userId
                + " AND product_code=" + productCode;
        return query;
    }
}