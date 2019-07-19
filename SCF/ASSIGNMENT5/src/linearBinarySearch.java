
import java.util.*;

/**
 * There is two methods linear search and binary search.
 * Each of the above methods will receive an array
 * and an element to be search in array as input. It
 * will return the index where this element occurs 
 * in array. Assuming array to be sorted for Binary search.
 * 
 * @author Naman
 *
 */
public class linearBinarySearch {

	private int startIndex = 0;
	private int lastIndex = 0;
	private int midIndex = 0;
	//for checking if we want to change last index or not
	private boolean check = true;

	/**
	 * this method search the element in input array
	 * and return index if element found otherwise return -1
	 * 
	 * @param arr array of numbers
	 * @param element which we want to search in array
	 * @return the index where the element found otherwise -1
	 */
	
	 public int linearSearch(int arr[], int element)
	    {
	    	//throw error if array is empty
	    	if(arr.length == 0){
	    		throw new AssertionError();
	    	}
	    	//set last index to array length-1 when function first call
	    	if(startIndex == 0)
	    	{
	    		lastIndex = arr.length-1;
	    	}
	    	//checks if element at start or last 
	    	if(arr[startIndex]==element)
	    	{
	    		return startIndex;
	    	}else if(arr[lastIndex]==element){
	    	    return lastIndex;	
	    	}else if(startIndex >= lastIndex){
	    		//if element is not found then return -1
	    		return -1;
	    	}
	    	startIndex++;
	    	lastIndex--;
	    	//calling function recursively
	    	return linearSearch(arr,element);
	    }
	 
	 public int binarySearch(int sortedArr[],int element)
	 {
		//checks if array is empty then throw error
	    	if(sortedArr.length == 0){
	    		throw new AssertionError();
	    	}
	    	//checks if program run first time then set last index to length-1 of array
	        if(startIndex == 0 && check)
	        {
	        	lastIndex = sortedArr.length-1;
	        }
	    	if(startIndex < lastIndex)
	    	{
	    		//calculate mid index of array
	    		midIndex = startIndex + (lastIndex - startIndex)/2;
	    		//checks if mid element is the search element
		        if(sortedArr[midIndex]==element)
		            return midIndex;
		        else if(sortedArr[midIndex] > element) {
	        		 lastIndex = midIndex;
	        		 check = false;
	        		 //calls recursively this function 
	        		 return binarySearch(sortedArr,element);
	        	}else {
	        		startIndex = midIndex+1;
	                check = false;
	        		return binarySearch(sortedArr,element);
	        	}	
	    	}else if(startIndex == lastIndex && sortedArr[startIndex]==element){
	    		//checks if start index and last index is and both are pointing to search element then return that index 
	    		return startIndex;
	    	}else{
	    		//return -1 if element is not in array
	    		return -1;
	    	}   	
		
		 
	 }
}

class MyMain{
	public static void main(String args[]){
		
		linearBinarySearch lbs1=new linearBinarySearch();
		Scanner s = new Scanner(System.in);
		System.out.println("Select by typing number:");
		System.out.println("1. linear search");
		System.out.println("2. Binary search");
		System.out.println("Enter 1 or 2");
		int n=s.nextInt();
		System.out.print("Enter number of items want to insert in array: ");
		int numberElements=s.nextInt();
		int arr[]=new int[numberElements];
		for(int i=0 ; i<numberElements ; i++)
		{
			System.out.print("Enter "+(i+1)+" number: ");
			arr[i]=s.nextInt();
		}
		System.out.println("");
		System.out.println("Enter element you want to search: ");
		int element=s.nextInt();
		try{
			if(n==1)
			{
				int linearsearch=lbs1.linearSearch(arr,element);
				System.out.println(linearsearch+1);
			}
			else if(n==2)
			{
				int binarySearch=lbs1.binarySearch(arr,element);
				System.out.println(binarySearch);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
