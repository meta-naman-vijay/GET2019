import java.util.*;

public class StoreFront {
 public static void main(String args[]) {
  while (true) {
   System.out.println("Select options \n");
   Scanner scanner = new Scanner(System.in);
   int option = scanner.nextInt();
   switch (option) {
   case 1:
    System.out.println("order details of a user which is in shipped state");
    System.out.println("Enter uuserId: ");
    int userId = scanner.nextInt();
    List<orderDetail> listOfOrders = DatabaseHelper.getOrderDetails(userId);
    for (orderDetail orderDetail : listOfOrders) {
     System.out.println(orderDetail.getOrderId());
     System.out.println(orderDetail.getProductId());
     System.out.println(orderDetail.getOrderDate());
     System.out.println(orderDetail.getOrderTotal());
     System.out.println();
    }
    System.out.println();
    break;
   case 2:

    System.out.println("Insert Images Of Product");
    List<ProductImage> listOfImage = new ArrayList<ProductImage>();
    listOfImage.add(new ProductImage(1, 12, "image1.jpeg", "front"));
    listOfImage.add(new ProductImage(2, 13, "image2.jpeg", "left"));
    listOfImage.add(new ProductImage(2, 14, "image2.jpeg", "right"));
    listOfImage.add(new ProductImage(4, 15, "image3.jpeg", "top"));
    listOfImage.add(new ProductImage(5, 16, "image3.jpeg", "front"));
    listOfImage.add(new ProductImage(4, 17, "image1.jpeg", "left"));
    DatabaseHelper.insertImage(listOfImage);
    System.out.println();
    System.out.println();
    break;

   case 3:
    System.out.println(
      "Mark Product status inactive for all those products which were not ordered by any Shopper in last 1 year");
    int updatedRows = DatabaseHelper.updateProductStatus();
    System.out.println("updated rows " + updatedRows);
    System.out.println();
    System.out.println();
    break;

   case 4:
    System.out.println("Top category details with their number of children");
    List<TopCategoryDetail> listOfTopCategories = DatabaseHelper.getTopCategoryDetails();
    for (TopCategoryDetail TopCategoryDetail : listOfTopCategories) {
     System.out.println(TopCategoryDetail.getName());
     System.out.println(TopCategoryDetail.getNumberOfChildren());
     System.out.println();
    }
    break;
   default:
    System.out.println("Select valid option");

   }

  }
 }

}
