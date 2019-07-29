import java.util.*;

/**
 * This class is use to calculate the average grade
 * maximum grade minimum grade passed student percent
 *  
 * @author muzeeb
 *
 */
public class MainClassMarks {
	private static Marksheet marks = new Marksheet();
	
	/**
	 * takes the input of number of student from user 
	 * and grades of these students them calls 
	 * menu infinite times
	 * 
	 * @param args
	 */
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total number of students");
	    int numberOfStudents = sc.nextInt();
	    if(numberOfStudents>0){
	    	marks.inputStudentGrades(numberOfStudents);                             //takes student grade from user
			do{
				menu(numberOfStudents);
			}while(true);
		}else{
			System.out.println("Students number must be a positive integer");
			System.exit(0);
		}
	}

	/**
	 * menu function calls all these functions like
	 * avergae grade ,maximum grade minimum grade
	 * percentage of student who passed
	 * 
	 * @param numberOfStudents
	 */
	private static void menu(int numberOfStudents) {
		System.out.println("1. calculate average grade  \n2. calculate maximum grade \n3. calculate munimum grade \n4. calculated percentage of passed student \n5. Exit");
		System.out.println("choose any of these functions : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
		case 1:
			double averageGrade = marks.averageGrades(numberOfStudents);      //calculate average grade
			System.out.println("Average Grade : "+averageGrade);
			break;
		case 2:
			double maximumGrade = marks.maximumGrades(numberOfStudents);      //calculate maximum grade
			System.out.println("Maximum Grade : "+maximumGrade);
			break;
		case 3:
			double minimumGrade = marks.minimumGrades(numberOfStudents);      //calculate minimum grade
			System.out.println("Minimum Grade : "+minimumGrade);
			break;
		case 4:
			double percent = marks.passPercent(numberOfStudents);              //calculate passed student percentage
			System.out.println("Pass percent : "+percent);
			break;
		case 5:
			System.out.println("You have ended this program...!!!");
			System.exit(0);
		default:
			System.out.println("Wrong input please try again..!!");
		}
	}
} 
