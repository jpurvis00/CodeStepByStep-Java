/* Write a method named countUnique that accepts an array of integers as a parameter 
 * and returns a count of the number of unique values that occur in the array. If the 
 * array contains multiple occurrences of the same element value, only one of those 
 * occurrences should count toward your total. For example, if an array named numbers 
 * stores {7, 7, 2, 2, 1, 2, 2, 7}, the call of countUnique(numbers) should return 3 
 * because there are 3 unique values: 7, 2, and 1.
 * 
 * Constraints: In solving this problem, do not create any other data structures such 
 * as arrays, strings, etc., though you may create as many simple variables (e.g. int, double) 
 * as you like. Do not modify the array passed to your method as the parameter, such as by 
 * sorting or rearranging its element values. 
 */

package Arrays;

public class countUnique {
	public static void main(String[] args) {
		int[] numbers = {7, 7, 2, 2, 1, 2, 2, 7};
		int[] numbers2 = {1, 4, 8, 7, 7, 2, 2, 1, 2, 2, 7};
		int[] numbers3 = {7};
		
		System.out.println("# unique ints: " + countUnique1(numbers));
		System.out.println("# unique ints: " + countUnique1(numbers2));
		System.out.println("# unique ints: " + countUnique1(numbers3));
	}
	
	/* Checks the array to see how many unique #'s it contains.  Return that value.
	 * Pre:  Array is passed to method
	 * Post: Returns the # of unique #'s in the array
	 */
	private static int countUnique1(int[] arr) {
		int count = 0;
		
		//Check the entire array
		for(int i = 0; i < arr.length; i++) {
			//Change to true if we find dupes
			boolean found = false;
			//Check all values in the array that appear before arr[i] to see if any of
			//them equal arr[i].  If they do, change found to true.
			for(int j = i - 1; j >= 0; j--) {
				if(arr[i] == arr[j])
					found = true;
			}
			//If we did not find any dupes, increment count signifying it's a unique # in the array
			if(found == false)
				count++;
		}
		return count;
	}
}
