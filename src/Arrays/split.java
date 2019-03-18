/* Write a method named split that accepts an array of integers as a parameter
 *  and returns a new array twice as large as the original, replacing every 
 *  integer from the original array with a pair of integers, each half the original. 
 *  If a number in the original array is odd, then the first number in the new pair 
 *  should be one higher than the second so that the sum equals the original number. 
 *  For example, if a variable named a refers to an array storing the
 *  values {18, 7, 4, 24, 11}, the call of split(a) should return a new array
 *  containing {9, 9, 4, 3, 2, 2, 12, 12, 6, 5}. (The number 18 is split into the 
 *  pair 9, 9, the number 7 is split into 4, 3, the number 4 is split into 2, 2, the 
 *  number 24 is split into 12, 12 and the number 11 is split into 6, 5.)
 */

package Arrays;

public class split {
	public static void main(String[] args) {
		int[] arr = {18, 7, 4, 24, 11};
				
		int[] newArr = split1(arr);
		for(int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}
	
	/* Creates a new array 2x the size of the passed array.  It then splits the 
	 * values from the first array.  See method comments for specifics.
	 * Pre:  Array of ints is passed in
	 * Post: A new array is created and returned
	 */
	private static int[] split1(int[] a) {
		int[] b = new int[a.length * 2];
		int j = 0;
		
		//Do our calc on every # in the a array
		for(int i = 0; i < a.length; i++) {
			//a[i] is even, assign both new elements(b[0], b[1]) the same #
			if(a[i] % 2 == 0) {
				b[j] = a[i] / 2;
				b[j + 1] = b[j];
			} 
			//a[i] is odd, assign first #(b[0]) a[i] / 2 and the 2nd #(b[1])
			//a[i] / 2 - 1
			else {
				double temp = 0.0;
				temp = Math.round(a[i] / 2.0);
				b[j] = (int)temp;
				b[j + 1] = b[j] - 1;
			}
			//increment j by 2 each time so that we assign our #'s in incrementing 
			//blocks of two.  ie b[0]:b[1], b[2]:b[3], b[4]:b[5]
			j += 2;
		}
		return b;
	}
}
