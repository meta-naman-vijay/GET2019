import java.util.*;

/**
 * this class contains different function like
 * is both string equal ,reverse string ,changing
 * case and largest word
 * 
 * @author naman
 *
 */
public class StringOperations {
	
	/**
	 * taking input from user
	 * 
	 * @return user input's string
	 */
	public String input() {
		System.out.println("Enter input string : ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	/**
	 * checks if both string input are equal or not
	 * @param firstString 
	 * @param secondString
	 * @return true if both strings are equal otherwise false
	 */
	public Boolean isStringEqualFun(String firstString, String secondString) {
        if(firstString.length() == secondString.length()){
        	for(int i=0; i<firstString.length(); i++){
        		if(firstString.charAt(i) != secondString.charAt(i))                //checking each character of string
        			return false;
        		else
        			return true;
        	}
        }
        return false;
	}

	/**
	 * revese input string and return it
	 * 
	 * @param string
	 * @return reverse of string
	 */
	public String reverseStringFun(String string) {
		StringBuilder reverseString = new StringBuilder();                    //object of string builder to reverse string
		int length = string.length();
		for(int i=length-1; i>=0 ; i-- )
	    reverseString.append(string.charAt(i));                               //append each character in string builder
		return reverseString.toString();                                      //convert it into string in returns 
	}

	/**
	 * returns string after changing case of each character
	 * 
	 * @param normalString 
	 * @return change the case of each character of string normalString and returns
	 */
	public String changeCaseStringFun(String normalString) {
		StringBuilder changeCaseString = new StringBuilder();
        for(int i=0 ; i<normalString.length(); i++)
        {
        	char ch = normalString.charAt(i);                                 //ch represent each char of string
        	if(ch >= 65 && ch <= 90)                                          //if ch is uppercase then convert it into lower
        	    ch = (char) (ch + 32);
        	else if(ch >= 97 && ch <= 122)                                    //if ch is lower case then convert it into uppercase
        		ch = (char) (ch - 32);                        
        	changeCaseString.append(ch);
        }
        return changeCaseString.toString();		
	}
	
    /**
     * find the largest word in input string
     * and return it if both two or more word 
     * are of same length then returns last word
     * 
     * @param fullString
     * @return largest word in string full string
     */
	public String largestWordFun(String fullString) {
		String [] word = fullString.split(" ");                               //split string into array of word
	    String maxLengthWord = "";
	    for(int i = 0; i < word.length; i++){
	            if(word[i].length() >= maxLengthWord.length()){               //compare each word of string and fin max length word
	                  maxLengthWord = word[i];
	            } 
	    }
	    return maxLengthWord;
	}
	
    /**
     * checks if string is empty or null
     * 
     * @param string
     * @return true if string is not empty of null
     */
	public Boolean checkInput(String string) {
		if(string.length()==0 || string.equals(null))                           //checks if string is empty or null
		{
			System.out.println("String can't be null or empty..!!Try again");
			return false;
		}
		return true;	
	}
}