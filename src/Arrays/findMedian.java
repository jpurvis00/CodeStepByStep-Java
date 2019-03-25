/* Write a method named findMedian that accepts an array of integers as its parameter 
 * and returns the median of the numbers in the array. The median is the number that 
 * will appear in the middle if you arrange the elements in order. Assume that the array 
 * is of odd size (so that one sole element constitutes the median) and that the numbers 
 * in the array are between 0 and 99 inclusive.
 * 
 * For example, the median of {5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17} is 5, 
 * and the median of {42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27} is 25. 
 */

package Arrays;

import java.util.Arrays;

public class findMedian {
	public static void main(String[] args) {
		int[] list = {5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17};
		int[] list2 = {42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27};
		
		System.out.println("Median is: " + getMedian(list));
		System.out.println("Median is: " + getMedian(list2));
	}
	
	/* Sorts an array of odd size and returns the median of that array.
	 * Pre:  Unsorted array of odd size is passed to method
	 * Post: Array is sorted and the median value is returned
	 */
	private static int getMedian(int[] list) {
		//Sort array
		Arrays.sort(list);
		
		//Return median
		return list[list.length / 2];
	}
}
