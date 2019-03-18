/* Compute the average of the ints in an array. */

package Arrays;

public class computeAverage {
	public static void main(String[] args) {
		int[] arr = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
		int[] arr2 = {9, 8, 30, 5, 2};
		int[] arr3 = {10, 20, 30, 40, 50, 60, 70};
		
		System.out.println("Average = " + calcAverage(arr));
		System.out.println("Average = " + calcAverage(arr2));
		System.out.println("Average = " + calcAverage(arr3));
	}
	
	/* Calculates the average of all the #'s in an array.
	 * Pre:  An array is passed in
	 * Post: The average is returned 
	 */
	private static double calcAverage(int[] a) {
		double sum = 0.0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum / a.length;
	}
}
