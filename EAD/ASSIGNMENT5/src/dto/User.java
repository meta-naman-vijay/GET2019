package dto;

/**
 * @author Naman POJO class for User
 */
public class User {
    private int userId;
    private String userName;
    private String address;
    private String contactNumber;

    /**
     * Method to get User ID
     * 
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Method to set User ID
     * 
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Method to get User Name
     * 
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Method to set User Name
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Method to get User Address
     * 
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set User Address
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method to get User Contact Number
     * 
     * @return contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Method to set User Contact Number
     * 
     * @param contactNumber
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
