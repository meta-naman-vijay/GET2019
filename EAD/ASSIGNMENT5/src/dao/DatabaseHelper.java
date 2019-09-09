package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.CartItem;
import dto.Product;
import dto.User;

public class DatabaseHelper {
    /**
     * Method to fetch user
     * 
     * @return Map of user Key contains userId and value contains user
     */
    public static Map<Integer, User> getListOfUser() {
        Map<Integer, User> mapOfUser = new HashMap<Integer, User>();
        String query = Query.getListOfUserQuery();
        Connection connection = null;
        try {
            connection = SQLConnection.getConnection("ead_mvc");
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            // execute select query and returns result set
            ResultSet rset = statement.executeQuery();
            User user;
            while (rset.next()) {
                int userId = rset.getInt("user_id");
                String userName = rset.getString("user_name");
                String address = rset.getString("address");
                String contactNumber = rset.getString("contact_number");
                user = new User();
                user.setUserId(userId);
                user.setUserName(userName);
                user.setAddress(address);
                user.setContactNumber(contactNumber);
                mapOfUser.put(user.getUserId(), user);
            }
            SQLConnection.closeConnection(connection);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            SQLConnection.closeConnection(connection);
        }

        return mapOfUser;
    }

    /**
     * Method to fetch product
     * 
     * @return list of product
     */
    public static List<Product> getListOfProduct() {
        List<Product> listOfProduct = new ArrayList<Product>();
        String query = Query.getListOfProductQuery();
        Connection connection = null;
        try {
            connection = SQLConnection.getConnection("ead_mvc");
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            // execute select query and returns result set
            ResultSet rset = statement.executeQuery();
            Product product;
            while (rset.next()) {
                int productCode = rset.getInt("product_code");
                String productType = rset.getString("product_type");
                String productName = rset.getString("product_name");
                float productPrice = rset.getFloat("product_price");
                product = new Product();
                product.setProductCode(productCode);
                product.setProductType(productType);
                product.setProductName(productName);
                product.setProductPrice(productPrice);
                listOfProduct.add(product);
            }
            SQLConnection.closeConnection(connection);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            SQLConnection.closeConnection(connection);
        }

        return listOfProduct;
    }

    /**
     * Method to add product into cart
     * 
     * @param cart
     * @return rowAffected
     */
    public static int addProductIntoCart(CartItem cart) {
        String query = Query.getAddProductIntoCartQuery();
        Connection connection = null;
        int rowAffected = 0;
        try {
            connection = SQLConnection.getConnection("ead_mvc");
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            int counter = 1;
            statement.setInt(counter++, cart.getUserId());
            statement.setInt(counter++, cart.getProductCode());
            statement.setInt(counter++, cart.getQuantity());
            rowAffected = statement.executeUpdate();
            SQLConnection.closeConnection(connection);
        } catch (SQLException exception) {
            exception.printStackTrace();
            SQLConnection.closeConnection(connection);
        }
        return rowAffected;
    }

    /**
     * Method to get CartItem from cart
     * 
     * @param user
     * @return list of cart Item
     */
    public static List<CartItem> getCartDetail(int userId) {
        List<CartItem> listOfItemInCart = new ArrayList<CartItem>();
        String query = Query.getCartDetailQuery(userId);
        Connection connection = null;
        try {
            connection = SQLConnection.getConnection("ead_mvc");
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            // execute select query and returns result set
            ResultSet rset = statement.executeQuery();
            CartItem cartItem;
            while (rset.next()) {
                int productCode = rset.getInt("product_code");
                int quantity = rset.getInt("quantity");
                cartItem = new CartItem();
                cartItem.setUserId(userId);
                cartItem.setProductCode(productCode);
                cartItem.setQuantity(quantity);
                listOfItemInCart.add(cartItem);
            }
            SQLConnection.closeConnection(connection);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            SQLConnection.closeConnection(connection);
        }

        return listOfItemInCart;
    }

    /**
     * Method to update product into cart
     * 
     * @param cart
     * @return rowAffected
     */
    public static int updateProductIntoCart(CartItem cart) {
        String query = Query.updateProductIntoCartQuery(cart.getUserId(),
                cart.getProductCode());
        Connection connection = null;
        int rowAffected = 0;
        try {
            connection = SQLConnection.getConnection("ead_mvc");
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            int counter = 1;
            statement.setInt(counter++, cart.getQuantity());
            rowAffected = statement.executeUpdate();
            SQLConnection.closeConnection(connection);
        } catch (SQLException exception) {
            exception.printStackTrace();
            SQLConnection.closeConnection(connection);
        }
        return rowAffected;
    }

    /**
     * Method to remove product from cart
     * 
     * @param cart
     * @return rowAffected
     */
    public static int removeProductFromCart(CartItem cart) {
        String query = Query.removeProductFromCartQuery(cart.getUserId(),
                cart.getProductCode());
        Connection connection = null;
        int rowAffected = 0;
        try {
            connection = SQLConnection.getConnection("ead_mvc");
            // Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query);
            rowAffected = statement.executeUpdate();
            SQLConnection.closeConnection(connection);
        } catch (SQLException exception) {
            exception.printStackTrace();
            SQLConnection.closeConnection(connection);
        }
        return rowAffected;
    }
}
