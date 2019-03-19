/* Write a method named contains that accepts two arrays of integers a1 and a2 
 * as parameters and that returns a boolean value indicating whether or not a2's 
 * sequence of elements appears in a1 (true for yes, false for no). The sequence of 
 * elements in a2 may appear anywhere in a1 but must appear consecutively and in 
 * the same order. For example, if variables called a1 and a2 store the following values:
 * int[] a1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
 * int[] a2 = {1, 2, 1};
 * 
 * Then the call of contains(a1, a2) should return true because a2's sequence of 
 * values {1, 2, 1} is contained in a1 starting at index 5. If a2 had stored the 
 * values {2, 1, 2}, the call of contains(a1, a2) would return false because a1 does 
 * not contain that sequence of values. Any two arrays with identical elements are considered 
 * to contain each other, so a call such as contains(a1, a1) should return true.
 * 
 * You may assume that both arrays passed to your method will have lengths of at least 1. 
 * You may not use any Strings to help you solve this problem, nor methods that produce Strings such as Arrays.toString.
 */

package Arrays;

public class contains {
	public static void main(String[] args) {
		int[] a1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a2 = {1, 2, 1};
		
		int[] a3 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a4 = {1, 9};
		
		int[] a5 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a6 = {1, 2, 1, 8};
		
		int[] a7 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a8 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		
		int[] a9 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] a10 = {1, 6, 2, 1, 4, 1, 2, 1, 8, 10};
		
		System.out.println("Sequence has been found: " + contains1(a1, a2));
		System.out.println("Sequence has been found: " + contains1(a3, a4));
		System.out.println("Sequence has been found: " + contains1(a5, a6));
		System.out.println("Sequence has been found: " + contains1(a7, a8));		
		System.out.println("Sequence has been found: " + contains1(a9, a10));
	}
	
	/* Checks array a1 to see if the sequence of ints in a2 appear in the same order.
	 * See above desc for examples.
	 * Pre:  a1 and a2 are passed in
	 * Post: Returns true if the sequence is found and false if not 
	 */
	private static boolean contains1(int[] a1, int[] a2) {
		boolean matched = false;
		
		//Only check for the sequence if a2 is shorter or the same length as a1.
		//If it's longer, return false.
		if(a2.length < a1.length || a2.length == a1.length) {
			for(int i = 0; i < a1.length; i++) {
				//Always check the first int in a2 with whatever int we are on in a1
				if(a1[i] == a2[0]) {
					//This for loop, loops us through all of a2 unless one of the ints does not match.
					//If it doesn't match we break out of this for loop and go onto the next in in a1.
					for(int j = 1; j < a2.length; j++) {
						if(a1[i + j] != a2[j]) {
							matched = false;
							break;
						}
						else {
							//If j == the length of a2, then all ints in a2 match the sequence in a1.
							if(j == a2.length - 1)
								matched = true;
						}
					}
					//We can stop at the first sequence match. 
					if(matched == true)
						return true;
				}
			}
		}
		return false;
	}
}
