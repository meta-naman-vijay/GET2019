package controller;

import java.util.List;
import java.util.*;

import dao.DatabaseHelper;
import dto.User;

/**
 * @author Naman Class to validate user
 */
public class Validate {
    /**
     * @param userId
     * @return true if user is valid otherwise false
     */
    public boolean validateUser(int userId) {
        Map<Integer, User> listOfUserId = DatabaseHelper.getListOfUser();
        if (listOfUserId.containsKey(userId)) {
            return true;
        } else
            return false;
    }
}
