package dto;

/**
 * @author Naman POJO class for product
 */
public class Product {
    private int productCode;
    private String productType;
    private String productName;
    private float productPrice;

    /**
     * Method to get product Id
     * 
     * @return productCode
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * Method to set product Id
     * 
     * @param productCode
     */
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    /**
     * Method to get product type
     * 
     * @return productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Method to set product type
     * 
     * @param productType
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * Method to get product name
     * 
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Method to set product name
     * 
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Method to get product price
     * 
     * @return productPrice
     */
    public float getProductPrice() {
        return productPrice;
    }

    /**
     * Method to set product price
     * 
     * @param productPrice
     */
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
