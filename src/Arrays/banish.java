/* Write a method named banish that accepts two arrays of integers a1 and a2 as parameters 
 * and removes all occurrences of a2's values from a1. An element is "removed" by shifting 
 * all subsequent elements one index to the left to cover it up, placing a 0 into the last 
 * index. The original relative ordering of a1's elements should be retained.
 * 
 * For example, suppose the following two arrays are declared and the following call is made:
 * int[] a1 = {42, 3, 9, 42, 42, 0, 42, 9, 42, 42, 17, 8, 2222, 4, 9, 0, 1};
 * int[] a2 = {42, 2222, 9};
 * banish(a1, a2);
 * 
 * After the call has finished, the contents of a1 should become:
 * {3, 0, 17, 8, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
 * 
 * Notice that all occurrences of the values 42, 2222, and 9 have been removed and replaced 
 * by 0s at the end of the array, and the remaining values have shifted left to compensate.
 * 
 * Do not make any assumptions about the length of the arrays or the ranges of values each might contain. 
 * For example, each array might contain no elements or just one element, or very many elements. 
 * (If a2 is an empty array that contains no elements, a1 should not be modified by the call 
 * to your method.) You may assume that the arrays passed are not null. You may assume that 
 * the values stored in a2 are unique and that a2 does not contain the value 0.
 * 
 * You may not use any temporary arrays to help you solve this problem. 
 * (But you may declare as many simple variables as you like, such as ints.) 
 * You also may not use any other data structures or complex types such as Strings, 
 * or other data structures such as the ArrayList class.
 */

package Arrays;

public class banish {
	public static void main(String[] args) {
		int[] a1 = {42, 3, 9, 42, 42, 0, 42, 9, 42, 42, 17, 8, 2222, 4, 9, 0, 1};
		int[] a2 = {42, 2222, 9};
		int[] a3 = {42, 3, 9, 42, 42, 0, 42, 9, 42, 42, 17, 8, 2222, 4, 9, 0, 1};
		int[] a4 = {};
		
		System.out.print("Initial array: ");
		printArray(a1);
		System.out.print("Array values to remove: ");
		printArray(a2);
		System.out.print("New array: ");
		banish1(a1, a2);
		
		System.out.print("\n\nInitial array: ");
		printArray(a3);
		System.out.print("Array values to remove: ");
		printArray(a4);
		System.out.print("New array: ");
		banish1(a3, a4);
	}
	
	/* Checks array1 to see if any values in array2 occur in it.  If they do, removes the int
	 * from array1 and shifts the entire array to the left by 1.  Replaces the removed int with
	 * 0 adding this to the end of array1.
	 * Pre:  2 arrays are passed into the method
	 * Post: 1st array values have been removed if they are contained in 2nd array
	 */
	private static void banish1(int[] a1, int[] a2) {
		boolean removed = false;
		
		//Go through entire first array
		for(int i = 0; i < a1.length; i++) {
			//Go through the entire 2nd array
			for(int j = 0; j < a2.length; j++) {
				//Check to see if one of the ints in array2 is contained in array1.  If so, 
				//set removed to true.  This will be used later.
				if(a1[i] == a2[j]) {
					removed = true;
					//Shift the entire array to the left by one and add a 0 to the end of the array
					//which "replaces" the removed int
					for(int k = i; k < a1.length - 1; k++) {
						a1[k] = a1[k + 1];
					}
					a1[a1.length - 1] = 0;
				}
			}
			//This is needed because by shifting all #'s left, we would have an instance of the i
			//in the for loop being ahead of all shifted numbers.  If a # is removed, deincrement i
			//by 1 so we can recheck the shifted values.
			if(removed == true)
				i--;
			
			//Reset to false.  We only want to deincrement i when we have actually removed a value.
			removed = false;
		}
		printArray(a1);
	}
	
	/* Prints the array */
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
}
