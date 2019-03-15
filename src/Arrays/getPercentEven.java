/* Checks an array for even #'s and returns the percentage that they occur. */

package Arrays;

public class getPercentEven {
	public static void main(String[] args) {
		int[] arr = {6, 4, 9, 11, 5};
		int[] arr2 = {6, 4, 9, 11, 5, 6, 10};
				
		System.out.println("Even # %: " + calcPercentEven(arr));
		System.out.println("Even # %: " + calcPercentEven(arr2));
	}
	
	/* Calculates the percentage of even #'s in an array.
	 * Pre:  An array is passed into the method
	 * Post: Returns the percentage
	 */
	private static double calcPercentEven(int[] a) {
		double numEvens = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] % 2 == 0)
				numEvens++;
		}
		
		return (numEvens * 100) / a.length;
	}
}
