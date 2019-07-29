import java.util.Scanner;

/**
 * this class calling menu infinite times which contains all operation of string
 * 
 * @author naman
 *
 */
public class MainClassString {
	static StringOperations obj = new StringOperations();

	/**
	 * calling menu infinite times
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		do {
			menu();
		} while (true);
	}

	/**
	 * it contains the menu of all function user choose and can perform and it also
	 * takes input from user
	 */
	private static void menu() {
		System.out.println(
				"1. Is Strings Equal \n2. Reverse String \n3. Change case of string \n4. Largest word \n5. Exit");
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose any operation");
		int choice = sc.nextInt(); // user's choice to calculate functions
		switch (choice) {
		case 1:
			String firstString = obj.input(); // taking string input from user
			String secondString = obj.input(); // taking string input from user
			if (obj.checkInput(firstString) && obj.checkInput(secondString)) {
				if (obj.isStringEqualFun(firstString, secondString)) { // checking if both strings are equal or not
					System.out.println("Strings are equal");
				} else {
					System.out.println("Strings are not equal");
				}
			}
			break;
		case 2:
			String string = obj.input(); // taking string input from user
			if (obj.checkInput(string)) {
				String reverseString = obj.reverseStringFun(string); // reversing input string
				System.out.println("Reverse of string '" + string + "' is : " + reverseString);
			}
			break;
		case 3:
			String normalString = obj.input(); // taking string input from user
			if (obj.checkInput(normalString)) {
				String changeCaseString = obj.changeCaseStringFun(normalString); // changing case of string and
																					// returning
				System.out.println("String '" + normalString + "' after changing the case of each character is : "
						+ changeCaseString);
			}
			break;
		case 4:
			String fullString = obj.input(); // taking input string from user
			if (obj.checkInput(fullString)) {
				String largestWord = obj.largestWordFun(fullString); // returning largest word from fullString string
				System.out.println("Largest word in the String '" + fullString + "' is : " + largestWord);
			}
			break;
		case 5:
			System.out.println("You have closed the program ");
			System.exit(0);
			break;
		default:
			System.out.println("Oops wrong input...!! Try again");
			break;
		}
	}
}