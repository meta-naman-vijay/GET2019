import java.util.Scanner;
/**
 * takes one double input from user 
 * 
 * @param diagram type like triangle , square 
 * @param length for the side or radius of diagram
 * @return result -user input
 */
public class Input {
	public double  areaInput(String diagram, String length) {
		System.out.println("Please input "+diagram+"'s "+length+" : "); 
		Scanner sc = new Scanner(System.in);
		double result = sc.nextDouble();
		return result;	
	}
}
