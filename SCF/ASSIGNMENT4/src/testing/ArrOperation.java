package testing;

public class ArrOperation {

	/**
	 * This function calculate the size of largest mirror
	 * in input array and return that size
	 * 
	 * @param numberArr array of numbers  
	 * @return maximum size of mirrorArrray
	 */
	public int maxMirror(int []numberArr)
	{
		 int length = numberArr.length;
		 //checks if numberArr is not empty then throw exception 
		 if(numberArr.length == 0)
			 {
			    throw new AssertionError();	
			 }
		 //for counting size of largest mirro
	     int count= 0;                   
     	 int max = 0;
     	 //for taking elements from strat index
     	 for(int i=0 ; i<length ; i++)
     	 {
     		 count = 0;
     		 //for taking elements from end index 
     		 for(int j=length-1 ; i+count < length && j >=0 ; j--)
     		 {
     			 //checks if both values are equal
     			if(numberArr[i+count] == numberArr[j])
     			{
     				count++;
     				//calculate max value
     				max = count>max ? count : max;
     			}else
     			{
     				//calculate max value
     				max = count>max ? count : max;
     				count = 0;
     			}
     		 }
     	 }
     	 return max;
	}
	public int numberOfClumps(int [] numberArr)
	{
		 //throw exception if arr is empty
		if(numberArr.length == 0)
			{
			    throw new AssertionError();	
			}
		//To count the number of clumps
		int count = 0;
		boolean sameNumber = false;
		for(int i=0 ; i<numberArr.length-1 ; i++){
			//enter if we found clumps 
			if((numberArr[i] == numberArr[i+1]) && !sameNumber)
			{
				count++;
				sameNumber = true;
			}else if(numberArr[i] != numberArr[i+1])
			{
				sameNumber = false;
			}
		}
        return count;
	}
	public int[]  fixXY(int []numberArr, int X , int Y)
	{
		int length = numberArr.length;
		//1.throw exception if arr is empty
		if(numberArr.length == 0)
		{
		    throw new AssertionError();	
		}
		//2.throw exception if there is unequal numbers of X and Y
		int counter1 = 0;
		int counter2 = 0;
		for(int i=0 ; i<length ; i++)
		{
			if(numberArr[i]==X)
			{
				counter1++;
			}
			if(numberArr[i]==Y)
			{
				counter2++;
			}
		}
		//checking if both X and Y are in same numer
		if(counter1 != counter2)
		{  
			throw new AssertionError();			
		}
		//3.throw exception if there are adjacent X
		for(int i=0 ; i<length-1 ; i++)
		{
			if(numberArr[i]==X && numberArr[i+1]==X)
			{
				throw new AssertionError();
			}
		}
		//4.throw exception if last element of arr is X
		if(numberArr[length-1]==X)
		{
			throw new AssertionError();
		}
		//To remember that we have checked that Y value
		int remember = 0;
		//Taking index from starting
		for(int i=0 ; i<length-1 ; i++)
		{   
			//go inside if condition if we have found X in array
			if(numberArr[i]==X)
			{   
				//taking index after the fixXY value
				for(int j=remember ;  j<length ; j++)
				{
					//swapping Y with j index arr
					if(numberArr[j]==Y && j != i+1)
					{
						int temp;
						temp = numberArr[i+1];
						numberArr[i+1] = numberArr[j];
						numberArr[j] = temp;
						remember = i+2;
					}
				}
			}
		}
		return numberArr;
	}
	

	public int splitArray(int[] numberArr) 
	{
		 //throw exception if array is empty
		if(numberArr.length == 0)
			{
			    throw new AssertionError();	
			}
		int totalSum = 0;
		int index=0;
		for(int i=0 ; i<numberArr.length ;i++)
		{
		   //calculating total sum of array's elements
		   totalSum = totalSum + numberArr[i];
		}
		//enter if total sum is even
		if(totalSum%2 == 0)
		{
			int halfSum = totalSum/2;
			int sum = 0;
			//loops until halfSum is not equal to sum
			while(sum != halfSum) 
			{   
				sum = sum+numberArr[index];
				index++;
				if(sum > halfSum)
				{
					return -1;
				}
			}
			return index;
		}
		return -1;
	}
	

	public static void main(String[] args) {
		ArrOperation obj=new ArrOperation();
		int arr[]={1,2,1,4};
		int max=obj.maxMirror(arr);
		System.out.println(max);
		int arr1[]={1,1,1,1,1};
		int count=obj.numberOfClumps(arr1);
		System.out.println(count);
		int arr2[]={1,4,1,5,5,4,1};
		int arr3[]=obj.fixXY(arr2,4,5);
		for(int i=0;i<=6;i++)
			System.out.print(arr3[i]);
		int arr4[]={10,10};
		int split=obj.splitArray(arr4);
		System.out.println(" ");
		System.out.println(split);
		
		
	}

}
