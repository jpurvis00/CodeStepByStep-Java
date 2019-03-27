/* Write a method named nCopies that accepts an array of integers a as a parameter and 
 * returns a new array a2, with each element value n from a replaced by n consecutive 
 * copies of the value n at the same relative location in the array. For example, if 
 * an array named a stores the following element values:
 * 
 * {3, 5, 0, 2, 2, -7, 0, 4}
 * 
 * Then the call of int[] a2 = nCopies(a); should return a new array a2 containing the 
 * following elements. The idea is that the value 3 was replaced by three 3s; the 5 was 
 * replaced by five 5s; and so on.
 * 
 * {3, 3, 3, 5, 5, 5, 5, 5, 2, 2, 2, 2, 4, 4, 4, 4}
 * 
 * Any element whose value is 0 or negative should not be kept in the returned array (as with 0 and -7 above).
 * 
 * The array you return must have a length that is exactly long enough to fit its elements. 
 * For example, the result array a2 above contains 3 + 5 + 2 + 2 + 4 = 16 total elements, 
 * so the returned array's length must be exactly 16 in that case.
 * 
 * Constraints: In solving this problem, you must create a single new array to be returned,
 * but aside from that, do not create any other data structures such as temporary arrays or strings. 
 * You may use as many simple variables (such as ints) as you like.
 */

package Arrays;

public class nCopies {
	public static void main(String[] args) {
		int[] arr = {3, 5, 0, 2, 2, -7, 0, 4};
		
		int[] arr2 = nCopies1(arr);
		printArray(arr2);
	}
	
	/* Creates a new array and populates it with the positive ints from the passed array n times.
	 * See description above for an example.
	 * Pre:  Array of ints is passed into the method
	 * Post: New array has been created, populated and returned
	 */
	private static int[] nCopies1(int[] arr) {
		//Call getNewArrayLength to figure out how big our new array needs to be
		int newArrLength = getNewArrayLength(arr);
		//Create our new array
		int[] arr2 = new int[newArrLength];
		//Keeps track of what position in the new array to put then next int
		int arrPos = 0;

		//Go through entire array
		for(int i = 0; i < arr.length; i++) {
			//Ignore all ints that are < 1
			if(arr[i] > 0) {
				//Add the value of the pos int from the orig array to the new array n times.
				//n being the current value of arr[i]
				for(int j = 0; j < arr[i]; j++) {
					arr2[arrPos] = arr[i];
					arrPos++;
				}
			}
		}
		return arr2;
	}
	
	/* Calculates how big the new array will need to be.  This is done by adding up all 
	 * non 0 and non neg #'s and returns the value.
	 * Pre:  Populated array is passed into the method
	 * Post: Length of the new array is returned
	 */
	private static int getNewArrayLength(int[] arr) {
		int length = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0)
				length += arr[i];
		}
		
		return length;
	}
	
	/* Prints the array */
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
