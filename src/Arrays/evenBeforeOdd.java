/* Write a method named evenBeforeOdd that accepts an array of integers as a parameter 
 * and rearranges its elements so that all even values appear before all odds. For 
 * example, if the following array is passed to your method:
 * int[] numbers = {5, 2, 4, 9, 3, 6, 2, 1, 11, 1, 10, 4, 7, 3};
 * 
 * Then after the method has been called, one acceptable ordering of the elements would be:
 *                 {4, 2, 4, 10, 2, 6, 3, 1, 11, 1, 9, 5, 7, 3}
 *                 
 * The exact order of the elements does not matter, so long as all even values appear 
 * before all odd values. For example, the following would also be an acceptable ordering:
 *                 {2, 2, 4, 4, 6, 10, 1, 1, 3, 3, 5, 7, 9, 11}
 * Do not make any assumptions about the length of the array or the range of values it 
 * might contain. For example, the array might contain no even elements or no odd elements.
 * 
 * You should not use any temporary arrays to help you solve this problem. (But you may 
 * declare as many simple variables as you like, such as ints.) You may not use any other 
 * data structures such as Strings orArrayLists. You should not use Arrays.sort in your solution. 
 */

package Arrays;

public class evenBeforeOdd {
	public static void main(String[] args) {
		int[] numbers = {5, 2, 4, 9, 3, 6, 2, 1, 10, 4, 7, 3};
		int[] numbers2 = {5, 2, 4, 9, 3, 6, 2, 1, 10, 4, 7};
		int[] numbers3 = {1, 3, 5, 7, 9, 2};
		int[] numbers4 = {2, 4, 6, 8, 10, 1};
		
		evenBeforeOdd1(numbers);
		evenBeforeOdd1(numbers2);
		evenBeforeOdd1(numbers3);
		evenBeforeOdd1(numbers4);
	}
	
	/* Moves all even numbers in an array to the front of the array and all odd numbers
	 * to the end of the array.  Int value does not matter in the sort.  All we care about
	 * is that all even #'s appear before any odd #'s.
	 * Pre:  Unsorted array is passed into method
	 * Post: All even numbers have been moved to the front of the array followed by all odd
	 */
	private static void evenBeforeOdd1(int[] a) {
		//Start at the end of the array and only check half of it
		for(int i = a.length - 1; i >= a.length / 2; i--) {
			//If the int is even
			if(a[i] % 2 == 0) {
				//Start at the beg of the array.  We only need to check the first half as well.
				for(int j = 0; j < a.length / 2; j++) {
					//If the int is odd, swap it with the even number found in the first for loop.
					if(a[j] % 2 == 1) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
		}
		
		//Print out new array.
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
}
