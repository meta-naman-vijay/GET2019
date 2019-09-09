package view;

import java.io.*;
import java.util.*;

import controller.UserCart;
import controller.Validate;
import dto.CartItem;
import dto.Product;

public class Application {
    public static void main(String args[]) {
        Scanner scanIn = new Scanner(System.in);
        // validation
        System.out.print("Enter your User ID :");
        int userId = scanIn.nextInt();
        Validate validateObj = new Validate();
        if (!validateObj.validateUser(userId))
            System.out.println("Wrong User ID");
        else {
            // to show all products to user
            TotalProduct.showAllProduct();
            // to add product into cart

            System.out.println("1. To Add  Item to Your Cart :");
            System.out.println("2. To Update  Item to Your Cart :");
            System.out.println("3. To Remove  Item from Your Cart :");
            System.out.println("4. To Show Your Cart :");
            int choice = scanIn.nextInt();
            UserCart cart = new UserCart();
            switch (choice) {
            case 1:
                System.out.print("Enter Product Code :");
                int productCode = scanIn.nextInt();
                if (!TotalProduct.productContains(productCode))
                    System.out.println("Product Not found");
                else {
                    System.out.print("Enter Product Quantity :");
                    int quantity = scanIn.nextInt();
                    if (cart.addItem(userId, productCode, quantity))
                        System.out.print("Item Added ");
                    else
                        System.out.print("Not Added");
                }
                break;

            case 2:
                System.out.print("Enter Product Code :");
                productCode = scanIn.nextInt();
                if (!cart.checkItemInCart(userId, productCode))
                    System.out.println("Product Not In Cart");
                else {
                    System.out.print("Enter Product Quantity :");
                    int quantity = scanIn.nextInt();
                    if (cart.updateItem(userId, productCode, quantity))
                        System.out.print("Item Updated ");
                    else
                        System.out.print("Not Updated");
                }
                break;
            case 3:
                System.out.print("Enter Product Code :");
                productCode = scanIn.nextInt();
                if (!cart.checkItemInCart(userId, productCode))
                    System.out.println("Product Not In Cart");
                else {
                    if (cart.removeItem(userId, productCode))
                        System.out.print("Item Removed ");
                    else
                        System.out.print("Not Removed");
                }
                break;
            case 4:
                List<CartItem> listOfItemInCart = cart.getCartItems(userId);
                CartItem item;
                System.out.println("Product Code\t\tProduct Quantity\t\t");
                for (int i = 0; i < listOfItemInCart.size(); i++) {
                    item = listOfItemInCart.get(i);
                    System.out.print("\t" + item.getProductCode() + "\t\t");
                    System.out.print(item.getQuantity() + "\t\t");
                    System.out.println();
                }
                break;
            default:
                System.out.println("Wrong Entry ");

            }
        }

    }
}
