import java.util.*;
/**
 * 
 * function of Hcf using Euclid's Algorithm
 * and LCM of two numbers
 * 
 * @author Naman
 *
 */

public class lcmHcf {
	/**
	 * calculates H.C.F. of these two input numbers
	 * and return result of that
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return H.C.F of first and second number
	*/
	public int findHcf(int firstNumber, int secondNumber)
	{
		if(firstNumber==0)
			return secondNumber;
		else
			return findHcf(secondNumber%firstNumber,firstNumber);
	}
	/**
	 * calculates L.C.M. of these two input numbers
	 * and return result of that
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return L.C.M. of first and second number
	*/
	public int findLcm(int firstNumber, int secondNumber)
	{
		int hcf = findHcf(firstNumber , secondNumber);
    	//formula to find L.C.M using H.C.F
    	return (firstNumber*secondNumber)/hcf; 
	}
	public static void main(String[] args) {
	       
		lcmHcf obj=new lcmHcf();
		int firstNumber=12;
		int secondNumber= 4;
		int hcf=obj.findHcf(firstNumber,secondNumber);
		System.out.println(hcf);
		int lcm=obj.findLcm(firstNumber, secondNumber);
		System.out.println(lcm);
		
		
		
		
		
		
		
	}
}
