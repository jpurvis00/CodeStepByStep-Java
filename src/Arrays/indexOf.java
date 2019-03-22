/* Write a method named indexOf that returns the index of a particular value
 * in an array of integers. The method should return the index of the first 
 * occurrence of the target value in the array. If the value is not in the array, 
 * it should return -1. For example, if an array called list stores the following values:
 * int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0};
 * 
 * Then the call indexOf(list, 8) should return 4 because the index of the first 
 * occurrence of value 8 in the array is at index 4. The call indexOf(list, 2) should 
 * return -1 because value 2 is not in the array.
 */

package Arrays;

public class indexOf {
	public static void main(String[] args) {
		int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0};
		
		System.out.println("Index = " + findIndex(list, 8));
		System.out.println("Index = " + findIndex(list, 0));
		System.out.println("Index = " + findIndex(list, 2));
	}
	
	/* Searches an array for the specified value and returns the array
	 * index if found.  Return -1 if not found.
	 * Pre:  Array is passed along with a specified int to find in the array
	 * Post: Return the found index or a -1 if not found. 
	 */
	private static int findIndex(int[] list, int n) {
		int found = -1;
		
		//Go through entire array
		for(int i = 0; i < list.length; i++) {
			//Check to see if the int in the array equals the specified int.  If so
			//return the index of the first occurrence.
			if(list[i] == n)
				return i; 
		}
		return found;
	}
}
