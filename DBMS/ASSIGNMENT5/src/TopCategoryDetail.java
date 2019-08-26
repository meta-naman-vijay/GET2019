/**
 * This class represents Top category details with their child count.
 *
 */
public class TopCategoryDetail {
 private String category_name;
 private int numberOfChildren;

 public String getName() {
  return category_name;
 }

 public void setName(String category_name) {
  this.category_name = category_name;
 }

 public int getNumberOfChildren() {
  return numberOfChildren;
 }

 public void setNumberOfChildren(int numberOfChildren) {
  this.numberOfChildren = numberOfChildren;
 }

}