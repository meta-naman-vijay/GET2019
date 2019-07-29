import java.util.*;

/**
Marksheet class is to input the grades (0 to 100) of n students
and calculate the average of all grades, calculate the percentage
of students passed, find the minimum and maximum of all grades.
*/
class Marksheet
{ 
	private double grades[];				                                  //Array of grades of the students.

	/**
	 * To input the grades and keep them in an array 'grades'.
	 * 
	 * @param numberOfStudent is the number of students of type int.
	 */
	void inputStudentGrades(int numberOfStudent)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the grades of students ");
		grades = new double[numberOfStudent];
		try{
			for(int i=0; i<numberOfStudent; i++)
			{
				grades[i] = sc.nextDouble();                                    //getting grade from user for each student
				if(!(grades[i]>=0 && grades[i]<=100))
				{
					System.out.println("grades must be between 0 to 100 ...!!!");
					inputStudentGrades(numberOfStudent);                        //calling input function again if grade is not between 0 to 100
				}
				
			}	
		}catch(Exception e){
			System.out.println("Wrong input..!! try again");
			inputStudentGrades(numberOfStudent);
		}
		
	}
	
	/**
	 * To calculate the average grades from the array 'grades'.
	 * 
	 * @param numberOfStudents
	 * @return average of grades of n students as type double.
	 */
	double averageGrades(int numberOfStudents)
	{
		double totalGrades = 0;		
		for(int i=0; i<numberOfStudents; i++)
		{
			totalGrades += grades[i];                              //adds all grades
		}
		return (totalGrades/numberOfStudents);
	}
	
	/**
	 * To find the minimum of all the grades.
	 * 
	 * @param numberOfStudents
	 * @return minimum of all the grades as type double.
	 */
	double minimumGrades(int numberOfStudents)
	{
		double min = 100;					                       //Initializing minimum with maximum value for comparison		
		for(int i=0; i< numberOfStudents; i++)
		{
			if(grades[i] < min)
			{
				min = grades[i];                                   //find the minimum grade
			} 
		}
		return min;
	}
	
	/**
	 * To find the maximum of all the grades.
	 * 
	 * @param numberOfStudents
	 * @return maximum of all the grades as type double.
	 */
	double maximumGrades(int numberOfStudents)
	{
		double max = 0;					                          //Initializing maximum with the lowest value for comparison.
		
		for(int i=0 ; i< numberOfStudents ; i++)
		{
			if(grades[i] > max)
			{
				max = grades[i];                                  //find the max grade
			}
		}
		return max;
	}
	
	/**
	 * To calculate the percentage of total students passed.
	 * 
	 *  @return percentage of students passed as type double.
	 */
	double passPercent(int numberOfStudents)
	{
		double passedStudents = 0;					                 //For counting the number of students passed.
		for(int i =0; i<numberOfStudents; i++)
		{
			if(grades[i] >= 40)
			{
				passedStudents++;                                     //total passed student
			}
		}
		return ((passedStudents/numberOfStudents)*100);
	}
}