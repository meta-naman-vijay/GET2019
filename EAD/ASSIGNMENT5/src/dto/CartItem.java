package dto;

/**
 * @author Naman POJO class for Cart
 */
public class CartItem {
    private int userId;
    private int productCode;
    private int quantity;

    /**
     * Method to get user ID from Cart
     * 
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Method to set user ID into Cart
     * 
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Method to get product ID from Cart
     * 
     * @return productCode
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Method to set product ID into Cart
     * 
     * @param productCode
     */
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    /**
     * Method to get product quantity from Cart
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method to set product quantity into Cart
     * 
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
