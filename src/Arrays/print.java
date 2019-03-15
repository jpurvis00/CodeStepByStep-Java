/* Pass an array to a method and print out all the values.  */

package Arrays;

public class print {
	public static void main(String[] args) {
		int[] arr = {32, 5, 27, -3, 2598};
		
		printArray(arr);
	}
	
	/* Prints the elements of a passed array */
	private static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println("element [" + i + "] is " + a[i]);
		}
	}
}
