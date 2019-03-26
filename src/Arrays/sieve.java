/* Write a complete console program named Sieve that uses the "Sieve of Eratosthenes" algorithm 
 * to print a list of prime numbers between 2 and a given maximum. You will represent the numbers using an array.
 * In the third century B.C., the Greek astronomer Eratosthenes developed an algorithm for finding 
 * all the prime numbers up to some upper limit N. To apply the algorithm, you start by writing down 
 * a list of the integers between 2 and N. For example, if N is 10, you would write down the following list:
 * 
 * 2 3 4 5 6 7 8 9 10
 * 
 * You then underline the first number in the list and cross off every multiple of that number. Thus, 
 * after executing the first step of the algorithm, you will underline 2 and cross off every multiple of 2:
 * 
 * 2 3 4 5 6 7 8 9 10
 * 
 * From here, you simply repeat the process: underline the first number in the list that is neither 
 * crossed nor underlined, and then cross off its multiples. Eventually, every number in the list 
 * will either be underlined or crossed out, as shown below. The underlined numbers are prime.
 * 
 * 2 3 4 5 6 7 8 9 10
 * 
 * Your program should prompt the user to enter a max value N, and then perform the Sieve of 
 * Eratosthenes algorithm on the range of numbers 2 through N inclusive. You may assume that the 
 * user types a number that is at least 2. Here is an example output from one run of your program, 
 * with user input shown like this:
 * 
 * Max value N? 100
 * Primes: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
 * 
 * You must use an array in your solution to this problem. Part of your task in this problem is 
 * figuring out how to use an array to represent the list of numbers and how to remember which 
 * ones are prime, which ones are "underlined" vs "crossed off," and so on. 
 */

package Arrays;

import java.util.*;

public class sieve {
	public static void main(String[] args) {
		System.out.print("Max Value N? ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		
		int[] primeArray = findPrime(n);
		printArray(primeArray);
	}
	
	/* Goes through an array and finds all the prime #'s.  It does this by making multiple passes
	 * through the array and replacing any values that are divisible by the current element with a 0.
	 * Pre:  The # of digits you want to check for primes is passed into the method  
	 * Post: An array of prime #'s and 0's has been created.
	 */
	private static int[] findPrime(int n) {
		//Initialize w n - 1 so that we don't go over the max n
		int[] arr = new int[n - 1];
			
		//Initialize array starting at 2 and ending at n
		for(int i = 0; i < n - 1; i++) {
			arr[i] = 2 + i;
		}
		
		//Holds the # to check the rest of the array against
		int temp = 0;
		
		//Go through the entire array.  Each time through we will make the element of the array
		//equal to temp.  We will then check it against all the #'s in the remaining part of the array.
		for(int i = 0; i < arr.length; i++) {
			temp = arr[i];
			//See if each # in the remaining array is divisible by temp.  If so, replace it with
			//a 0 signifying that it is not a prime #.  Don't do the division if temp is 0 as it 
			//give us an arithmetic exception.
			for(int j = i + 1; j < arr.length; j++) {
				if(temp != 0 && arr[j] % temp == 0)
					arr[j] = 0;
			}
		}
		return arr;
	}
	
	/* Prints out all #'s that are not 0 signifying that they are prime #'s. */
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0)
				System.out.print(arr[i] + " ");
		}
	}
}
