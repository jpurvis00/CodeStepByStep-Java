/* Write a method that accepts an array and and returns the max value. */
 
package Arrays;
 
public class maxValue {

	public static void main(String[] args) {
		int[] arr = {17, 7, -1, 26, 3, 9, 999};
		
		System.out.println("Max #: " + getMaxValue(arr));
	}

	/* Finds the max # of the passed array.
	 * Pre:  An array is passed in
	 * Post: Returns the max value from the array
	 */
	private static int getMaxValue(int[] a) {
		int max = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] > max)
				max = a[i];
		}
		
		return max;
	}
}
