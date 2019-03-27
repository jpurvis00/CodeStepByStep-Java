/* Write a method named removePalindromes that that removes all strings that are 
 * palindromes from an array of strings.
 * 
 * Your method accepts an array of strings as a parameter and modifies its contents, 
 * replacing every string in the array that is a palindrome with an empty string, "". 
 * For example, if an array named a stores the following element values:
 * 
 * String[] a = {"Madam", "raceCAR", "", "hi", "A", "Abba", "banana", "dog God",
 *               "STOP otto POTS", "Madame", "Java", "LevEL", "staTS"};
 *               
 * Then the call of removePalindromes(a); should change it to contain the following 
 * element values. Notice that the palindromes from the array such as "Madam" and 
 * "LevEL" have been replaced by "".
 * 
 *              {"", "", "", "hi", "", "banana", "", "", "Madame", "Java", "", ""}
 *              
 * Constraints: You are to modify the existing array in-place. Do not create any other 
 * data structures such as temporary arrays. You may create as many strings as you like, 
 * and you may use as many simple variables (such as ints) as you like.
 * 
 * Note: You may want to go solve the string problem isPalindrome first and use it as part of your solution to this problem.
 */

package Arrays;

public class removePalindromes {
	public static void main(String[] args) {
		String[] str1 = {"Madam", "raceCAR", "", "hi", "A", "Abba", "banana", "dog God", 
				"STOP otto POTS", "Madame", "Java", "LevEL", "staTS"};
		
		remPalindromes(str1);
		printArray(str1);
	}
	
	/* Removes a palindrome from an array and replaces it with and empty string.
	 * Pre:  Array is passed into the method
	 * Post: All palindromes in the array have been replaced with an empty string
	 */
	private static void remPalindromes(String[] str) {
		//Go through the entire array
		for(int i = 0; i < str.length; i++) {
			//Pull out one word from the array at a time
			String word = str[i].toString();
			//Call checkPalindrome and pass it the word
			boolean isPalindrome = checkPalindrome(word);
			//If it is a palindrom, replace it w an empty string
			if(isPalindrome)
				str[i] = "";
		}
	}
	
	/* Checks to see if a word is a palindrome or not.  Returns true if it is and false if not.
	 * Pre:  One word from and array is passed into the method at a time
	 * Post: Returns true if the word is a palindrome and false if it's not
	 */
	private static boolean checkPalindrome(String word) {
		boolean isEqual = false;
		//Check each letter of the word
		for(int i = 0; i < word.length(); i++) {
			//Start at the first letter and compare it to the last letter in the word.  Then move in
			//from both directions by 1 char and compare those until all letters have been compared.
			//If any are not equal, isEqual will be set to false signifying that the word is not a palindrome.
			if(word.toLowerCase().charAt(i) == word.toLowerCase().charAt(word.length() - (i + 1)))
				isEqual = true;
			else
				isEqual = false;
		}
		return isEqual;
	}
	
	/* Print the array. */
	private static void printArray(String[] str) {
		//Print out new array
		for(int i = 0; i < str.length; i++) {
			//If palindrome has been removed, print out empty brackets for that spot in the array.
			//Else print out the non palindrome word
			if(str[i] == "")
				System.out.print("\"\" ");
			else
				System.out.print(str[i] + " ");
		}
	}
}
