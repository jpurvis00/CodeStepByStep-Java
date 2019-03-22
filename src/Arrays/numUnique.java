/* Write a method named numUnique that accepts a sorted array of integers 
 * as a parameter and that returns the number of unique values in the array. 
 * The array is guaranteed to be in sorted order, which means that duplicates 
 * will be grouped together. For example, if a variable called list stores the following values:
 * 
 * int[] list = {5, 7, 7, 7, 8, 22, 22, 23, 31, 35, 35, 40, 40, 40, 41};
 * 
 * then the call of numUnique(list) should return 9 because this list has 9 unique 
 * values (5, 7, 8, 22, 23, 31, 35, 40 and 41). It is possible that the list might 
 * not have any duplicates. For example if list instead stored this sequence of values:
 * 
 * int[] list = {1, 2, 11, 17, 19, 20, 23, 24, 25, 26, 31, 34, 37, 40, 41};
 * 
 * Then a call on the method would return 15 because this list contains 15 different values.
 * 
 * If passed an empty list, your method should return 0. Remember that you can assume that 
 * the values in the array appear in sorted (nondecreasing) order.
 */

package Arrays;

public class numUnique {
	public static void main(String[] args) {
		int[] list = {5, 7, 7, 7, 8, 22, 22, 23, 31, 35, 35, 40, 40, 40, 41};
		int[] list2 = {1, 2, 11, 17, 19, 20, 23, 24, 25, 26, 31, 34, 37, 40, 41};
		
		System.out.println("# of unique ints: " + countUnique(list));
		System.out.println("# of unique ints: " + countUnique(list2));
	}
	
	/* Counts the # of unique ints in the array.
	 * Pre:  Array is passed into the method
	 * Post: # of unique values is returned
	 */
	private static int countUnique(int[] list) {
		int count = 1;
		
		//Go through the entire array
		for(int i = 0; i < list.length - 1; i++) {
			//We know the array is sorted and all same #'s occur consecutively, therefor
			//only increment count if the are not equal.
			if(list[i] != list[i + 1])
				count++;
		}
	
		return count; 
	}
}
