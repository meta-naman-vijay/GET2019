import java.util.Scanner;

/**
 * main class contains the menu of all
 * these function like calculating area of
 * triangle ,circle ,rectangle and square 
 *
 * @author naman
 *
 */
public class MainClass {
	static Area area = new Area();
	static Input arInput = new Input();
	static double result;

	/**
	 * main function calls the menu for user infinite time unless user wants to exit
	 * program
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		do {
			menu();
		} while (true);

	}

	/**
	 * menu shows the menu of all functions of are. User can calculate any of these
	 * function
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	private static void menu() {
		System.out.println("1. Triangle Area \n2. Rectangle Area \n3. Square Area \n4. Circle Area \n5. Exit");
		System.out.println("Enter your choice : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			try {
				double hieght = arInput.areaInput("Triangle", "hieght");
				double width = arInput.areaInput("Traingle", "width");
				result = area.areaOfTraingle(hieght, width);
				System.out.println("Triangle Area :" + result);			// calculating area of traingle
			} catch (Exception e) {
				System.out.println("Invalid Input. please Input in coorect format");
			}
			break;

		case 2:
			try {
				double widthRectangle = arInput.areaInput("Rectangle", "width"); // getting width of rectangle
				double heightRectangle = arInput.areaInput("Rectangle", "height"); // getting height of rectangle
				result = area.areaOfRectangle(widthRectangle, heightRectangle); // calculating area of rectangle
				System.out.println("Rectangle Area :" + result);
			} catch (Exception e) {
				System.out.println("Wrong input formate...!! Try again");
			}
			break;
		case 3:
			try {
				double lengthSquare = arInput.areaInput("Square", "side"); // getting side of square
				result = area.areaOfSquare(lengthSquare); // Calculating area of square
				System.out.println("Square Area :" + result);
			} catch (Exception e) {
				System.out.println("Wrong input formate...!! Try again");
			}
			break;
		case 4:
			try {
				double radiusCircle = arInput.areaInput("Circle", "radius"); // getting radius of circle
				result = area.areaOfCircle(radiusCircle); // calculating area of circle
				System.out.println("Circle Area :" + result);
			} catch (Exception e) {
				System.out.println("Wrong input formate...!! Try again");
			}
			break;
		case 5:
			System.out.println("You have ended this programm...!!");
			System.exit(0);
			break;
		default:
			System.out.println("Oops wrong input... Try again...!!");
			break;
		}
	}

}
