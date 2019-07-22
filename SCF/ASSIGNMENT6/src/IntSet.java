import java.util.*;
/**
 * Implements immutable IntSet to perform following
 * operation one set like isMember , size of set
 * union of two set , find if a set is subset of others
 * or not ,and complement of set 
 * @author MUZEEB
 *
 */
public final class IntSet {
    private final int set[];
    private final int uniSet[] = new int[1000];
    
    /**
     * parameterized constructor to set uniSet value 
     * from 1 to 1000 and it sort our set array and 
     * checks if each element is between 1 to 1000
     * and no same values in set 
     * 
     * @param set
     */
    IntSet(int []set)
    {
    	//setting uniSet from 1 to 1000
        for(int indexOfSet=0 ; indexOfSet<1000 ; indexOfSet++)
        {
        	uniSet[indexOfSet] = indexOfSet+1;
        }
      //sorting set
       	Arrays.sort(set);
        //coping input set into object set
       	this.set = set;
       	//checks if set values are between 1 to 1000 otherwise throw assertion error
       	for(int index=0 ;index <set.length ; index++)
       	{
       		if(this.set[index]<1 || this.set[index]>1000)
       		{
       			throw new AssertionError();
       		}
       	}
       	//checking if set have one value more then once throw assertion error
       	for(int index=0 ; index<set.length ; index++)
       	{
       		for(int nextIndex=index+1 ; nextIndex<set.length ;nextIndex++)
       		{
       			if(this.set[index]==this.set[nextIndex])
       			{
       				throw new AssertionError();
       			}
       		}      		
       	}
    }
    
    /**
     * This function checks if input element 
     * is present in set or not 
     *  
     * @param element to be search in set
     * @return true if element is in set otherwise false
     */
    public boolean isMember(int element){
    	//checks if element is between 1 to 1000
    	if(element<1 ||element >1000)
    	{
    		throw new AssertionError();
    	}
        //checking if element is in set of not
    	for(int indexOfSet=0 ; indexOfSet<set.length ; indexOfSet++)
    	{
    	    if(set[indexOfSet] == element)
    	    {
    	    	return true;
    	    }
    	}
        return false;
    }
    
    /**
     * calculate size of set
     * 
     * @return size of set
     */
    public int size()
    {
    	return set.length;
    }
    
    /**
     * checks if passed set is subSet of the 
     * current set or not
     * 
     * @param subSetObj
     * @return true if passed set is subSet of called set
     */
    public boolean isSubSet(IntSet subSetObj) {
        int []subSet = subSetObj.set;
        for(int subSetIndex=0 ; subSetIndex<subSet.length ; subSetIndex++)
        {
        	//search each element of subSet into set  
        	if(!isMember(subSet[subSetIndex]))
        	{
        		return false;
        	}
        }
		return true;
	}

    /**
     * calculate complement of the input set
     * 
     * @return complement of input set
     */
    public int[] getComplement()
    {
    	//complement set size must be (1000-set size)
    	int complementSet[] = new int [1000-set.length];
    	int counter=0;
        for(int uniIndex = 0 ; uniIndex< 1000 ; uniIndex++)
        {
        	//checks each value between 1 to 1000 in to set 
        	//and if it's not in set then set it into complement array
    	   if(!isMember(uniSet[uniIndex])){
    		   complementSet[counter] = uniSet[uniIndex];
    		   counter++;
    	   }
       }
       return complementSet;
    }
    
    /**
     * find out union of two set 
     * 
     * @param firstSetObj set1 object
     * @param secondSetObj set2 object 
     * @return array of union set of these two object sets
     */
	public int[] union(IntSet firstSetObj, IntSet secondSetObj) {
		//to store first set 
    	int firstTemp[] = firstSetObj.set;
    	//to store second set
    	int secondTemp[] = secondSetObj.set;
    	//to store union set 
    	ArrayList<Integer> unionSet =new ArrayList<Integer>(secondTemp.length);
    	//coping second Array in to ArrayList
        for(int copyIndex=0 ; copyIndex < secondTemp.length; copyIndex++)
        {
        	unionSet.add(secondTemp[copyIndex]);
        }
    	for(int firstTempIndex=0 ; firstTempIndex<firstTemp.length ; firstTempIndex++)
     	{
    		//checks if second set doesn't contain that first set element
           if(!isMember(firstTemp[firstTempIndex]))
           {
        	   unionSet.add(firstTemp[firstTempIndex]); 
           }
    	}
    	//coping ArrayList into array
    	int unionSetArray[] = new int[unionSet.size()] ;
    	for(int copyIndex = 0; copyIndex < unionSet.size() ;copyIndex++)
    	{
    		unionSetArray[copyIndex] = unionSet.get(copyIndex);
    	}
    	Arrays.sort(unionSetArray);
    	return unionSetArray;
	}
	
}