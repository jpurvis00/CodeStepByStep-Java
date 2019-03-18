/* Write a method named longestSortedSequence that accepts an array of integers 
 * as a parameter and that returns the length of the longest sorted (nondecreasing) 
 * sequence of integers in the array. For example, if a variable named array stores the following values:
 * int[] array = {3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12};
 * then the call of longestSortedSequence(array) should return 4 because the longest 
 * sorted sequence in the array has four values in it (the sequence -3, 0, 14, 207). 
 * Notice that sorted means nondecreasing, which means that the sequence could contain 
 * duplicates. For example, if the array stores the following values:
 * int[] array2 = {17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19}
 * Then the method would return 5 for the length of the longest sequence 
 * (the sequence 3, 5, 5, 5, 8). Your method should return 0 if passed an empty array. 
 * Your method should return 1 if passed an array that is entirely in decreasing order or contains only one element.
 * Constraints: You may not use any auxiliary data structures (arrays, lists, strings, etc.) to solve this problem. 
 * Your method should not modify the array that is passed in.
 */

package Arrays;

public class longestSortedSequence {

	public static void main(String[] args) {
		int[] array = {3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12};
		int[] array2 = {17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19};
		int[] array3 = {};
		int[] array4 = {1};
		int[] array5 = {10, 9, 8, 7, 6, 5, 4};
		
		System.out.println("# sorted: " + countSortedSequence(array));
		System.out.println("# sorted: " + countSortedSequence(array2));
		System.out.println("# sorted: " + countSortedSequence(array3));
		System.out.println("# sorted: " + countSortedSequence(array4));
		System.out.println("# sorted: " + countSortedSequence(array5));
	}

	/*
	 * 
	 */
	private static int countSortedSequence(int[] a) {
		int count = 1;
		int longest = 0;
		
		//Return 1 if array only has 1 element
		if(a.length == 1)
			longest = 1;
		else if(a.length > 0) {
			for(int i = 0; i < a.length - 1; i++) {
				//Increment count if adjacent elements are in ascending order or repeat
				if(a[i] < a[i + 1] || a[i] == a[i + 1]) {
					count++;
				}
				//Adjacent elements are not in ascending order, reset count to 1 and 
				//record the # of elements that were in ascending order checking to see if
				//it is the longest ascending run.
				else {
					if(count > longest)
						longest = count;
					count = 1;
				}
			}
		}
		
		//Check to see if all elements are in descending order.  If so, return 1.
		if(longest != a.length) {
			for(int i = 0; i < a.length - 1; i++) {
				if(a[i] > a[i + 1]) {
					count++;
				}
				else
					break;
			}
			if(count == a.length)
				longest = 1;
		}
			
		return longest;
	}
}
