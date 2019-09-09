package controller;

import java.util.*;
import dao.DatabaseHelper;
import dto.CartItem;

public class UserCart {

    /**
     * Method to add item into cart
     * 
     * @param userId
     * @param productCode
     * @param quantity
     * @return true if item added
     */
    public boolean addItem(int userId, int productCode, int quantity) {
        CartItem cart = new CartItem();
        cart.setUserId(userId);
        cart.setProductCode(productCode);
        cart.setQuantity(quantity);
        if (DatabaseHelper.addProductIntoCart(cart) != 0)
            return true;
        else
            return false;
    }

    /**
     * Method to check item in cart
     * 
     * @param userId
     * @param productCode
     * @return true if item found in cart
     */
    public boolean checkItemInCart(int userId, int productCode) {
        List<CartItem> cartItemList = DatabaseHelper.getCartDetail(userId);
        Set<Integer> productCodeSet = new HashSet<Integer>();
        for (int i = 0; i < cartItemList.size(); i++) {
            productCodeSet.add(cartItemList.get(i).getProductCode());
        }
        if (productCodeSet.contains(productCode))
            return true;
        else
            return false;
    }

    /**
     * Method to update item in cart
     * 
     * @param userId
     * @param productCode
     * @param quantity
     * @return true if item updated
     */
    public boolean updateItem(int userId, int productCode, int quantity) {
        CartItem cart = new CartItem();
        cart.setUserId(userId);
        cart.setProductCode(productCode);
        cart.setQuantity(quantity);
        if (DatabaseHelper.updateProductIntoCart(cart) != 0)
            return true;
        else
            return false;
    }

    /**
     * Method to remove item from cart
     * 
     * @param userId
     * @param productCode
     * @param quantity
     * @return true if item removed from cart
     */
    public boolean removeItem(int userId, int productCode) {
        CartItem cart = new CartItem();
        cart.setUserId(userId);
        cart.setProductCode(productCode);
        if (DatabaseHelper.removeProductFromCart(cart) != 0)
            return true;
        else
            return false;
    }

    /**
     * Method to get list of item from cart
     * 
     * @param userId
     * @return list of CartItem
     */
    public List<CartItem> getCartItems(int userId) {
        return DatabaseHelper.getCartDetail(userId);

    }
}
