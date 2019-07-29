/**
 * Area class calculate the area of triangle,
 * area of rectangle ,area of square and area
 * of circle and it also takes input from user
 */

public class Area {
 	private double PI= 3.14;
 	 /**
     * calculate area of triangle
     * 
     * @param width of the triangle
     * @param height of the triangle 
     * @return area of the triangle
     */
 	public double areaOfTraingle(double width, double hieght){
		return (0.5 * width * hieght);
	}
	
	/**
	 * calculate area of rectangle
	 * 
	 * @param width of the rectangle
	 * @param height of the rectangle 
	 * @return area of rectangle
	 */
	public double areaOfRectangle(double width , double height) {
		return (width * height);                                         //calculating area of rectangle and returning 
	}
    
	/**
	 * calculate area of square
	 * 
	 * @param side of the square 
	 * @return area of the square
	 */
	public double areaOfSquare(double side) {
		return (side*side);                                             //calculating area of square and returning
 	}
    
	/**
	 * calculate area of circle
	 * 
	 * @param radius of the circle
	 * @return area of the circle
	 */
	public double areaOfCircle(double radius) {
		return (PI * radius * radius);                                  //calculating area of circle and returning
	}

}	
