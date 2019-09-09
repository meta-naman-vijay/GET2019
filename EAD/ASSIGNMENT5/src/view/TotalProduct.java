package view;

import java.util.*;

import dao.DatabaseHelper;
import dto.Product;
import dto.User;

/**
 * @author Naman
 * Class to show all product detail
 */
public class TotalProduct {

    private static Set<Integer> productCodeSet = new HashSet<Integer>();

    /**
     * Method to show all product
     */
    public static void showAllProduct() {
        List<Product> listOfProduct = DatabaseHelper.getListOfProduct();
        if (listOfProduct.size() == 0) {
            System.out.println("No product Found");
        } else {
            Product product;
            System.out.println("Product Code\t\tProduct Type\t\tName\t\tPrice");
            for (int i = 0; i < listOfProduct.size(); i++) {
                product = listOfProduct.get(i);
                productCodeSet.add(product.getProductCode());
                System.out.print("\t" + product.getProductCode() + "\t\t");
                System.out.print(product.getProductType() + "\t\t");
                System.out.print(product.getProductName() + "\t\t");
                System.out.print(product.getProductPrice() + "\t\t");
                System.out.println();
            }
        }
    }

    public static boolean productContains(int productCode) {
        if (productCodeSet.contains(productCode))
            return true;
        else
            return false;
    }

}
