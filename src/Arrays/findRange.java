/* Write a method that returns the range between the highest and
 * lowest #'s in the array.  ex. 6 and 17 -> 12... 1 and 1 -> 1
 */

package Arrays;

public class findRange {

	public static void main(String[] args) {
		int[] arr = {2, 5, 20, 3, 18, 30};
		
		System.out.println("Range: " + getRange(arr));
	}

	/* Finds and returns the range between the lowest and highest #'s in the array.
	 * Pre:  An array is passed in
	 * Post: The range is returned
	 */
	private static int getRange(int[] a) {
		int low = a[0];
		int high = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] < low)
				low = a[i];
			
			if(a[i] > high)
				high = a[i];
		}
		
		return (high - low) + 1;
	}
}
