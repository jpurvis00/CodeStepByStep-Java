/* Swap each set of 2 values in a String array all the way through the 
 * array.  Ex. aa, bb, cc, dd -> bb aa dd cc 
 */

package Arrays;

public class swichPairs {
	public static void main(String[] args) {
		String[] a = {"a", "bb", "c", "ddd", "ee", "f", "g"};
		String[] b = {"a", "bb", "c", "ddd", "ee", "f", "g", "h"};
		swapPairs(a);
		swapPairs(b);
	}
	
	/* Swaps each pair of two adjacent elements in a string array.  If there
	 * is an odd #, leave the last one alone.
	 * Pre:  A String array is passed in
	 * Post: Adjacent set of elements is swapped and printed out.
	 */
	private static void swapPairs(String[] a) {
		for(int i = 0; i < a.length - 1; i+=2) {
			String temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
		}
		
		for(int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.print("\n");
	}
}