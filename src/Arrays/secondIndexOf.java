/* Write a method named secondIndexOf that returns the index of the 
 * second occurrence of a particular value in an array of integers. 
 * If the value does not appear in the array at least twice, you should 
 * return -1. For example, if an array called list stores the following values:
 *     // index  0  1   2   3  4   5   6  7   8  9  10
 * int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0, 42};
 * 
 * Then the call secondIndexOf(list, 42) should return 6 because the index 
 * of the second occurrence of value 42 in the array is at index 6. The call 
 * secondIndexOf(list, 14) should return -1 because value 14 does not occur at least twice in the array.
 */

package Arrays;

public class secondIndexOf {
	public static void main(String[] args) {
		int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0};
		
		System.out.println("Index = " + findIndex(list, 8));
		System.out.println("Index = " + findIndex(list, 42));
		System.out.println("Index = " + findIndex(list, 2));
		System.out.println("Index = " + findIndex(list, 7));
	}
	
	/* Searches an array for the specified value and returns the array
	 * index if found.  Return -1 if not found.
	 * Pre:  Array is passed along with a specified int to find in the array
	 * Post: Return the found index or a -1 if not found. 
	 */
	private static int findIndex(int[] list, int n) {
		int found = -1;
		int count = 0;
		
		//Go through entire array
		for(int i = 0; i < list.length; i++) {
			//Check to see if the int in the array equals the specified int.  If so
			//return the index of the first occurrence.
			if(list[i] == n) {
				count++;
				if(count == 2)
					return i;
			}
				 
		}
		return found;
	}
}