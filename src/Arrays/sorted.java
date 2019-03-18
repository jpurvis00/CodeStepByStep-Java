/* Write a method that checks to see if an array is sorted.
 * If sorted, return true.
 */

package Arrays;

public class sorted {
	public static void main(String[] args) {
		double[] arr = {1.5, 4.3, 7.0, 19.5, 25.1, 46.2};
		double[] arr2 = {1.5, 4.3, 19.5, 7.0, 25.1, 46.2};
		double[] arr3 = {6.0, 1.5, 4.3, 19.5, 7.0, 25.1, 46.2};
		
		System.out.println("Sorted: " + checkSorted(arr));
		System.out.println("Sorted: " + checkSorted(arr2));
		System.out.println("Sorted: " + checkSorted(arr3));
	}
	
	/* Checks an array to see if its sorted.
	 * Pre:  Array is passed in
	 * Post: Returns true if array is sorted, false if not
	 */
	private static boolean checkSorted(double[] a){
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i] > a[i + 1])
				return false;
		}
		return true;
	}
}
