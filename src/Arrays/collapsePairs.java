/* Write a method named collapsePairs that accepts an array of integers as a 
 * parameter and modifies the array so that each of its pairs of neighboring 
 * integers (such as the pair at indexes 0-1, and the pair at indexes 2-3, etc.) 
 * are combined into a single sum of that pair. The sum will be stored at the 
 * even index (0,2,4, etc.) if the sum is even and at the odd index (1,3,5, etc.) 
 * if the sum is odd. The other index of the pair will change to 0.
 * 
 * For example, if an array named a stores the values {7, 2, 8, 9, 4, 22, 7, 1, 9, 10}, 
 * then the call of collapsePairs(a); should modify the array to contain the 
 * values {0, 9, 0, 17, 26, 0, 8, 0, 0, 19}. The first pair from the original 
 * array is collapsed into 9 (7 + 2), which is stored at the odd index 1 because 
 * 9 is odd. The second pair is collapsed into 17 (8 + 9), stored at the odd index 3; 
 * the third pair is collapsed into 26 (4 + 22), stored at the even index 4; and so on. 
 * The figure below summarizes the process for this example array:
 * before: index  0   1   2   3   4   5   6   7   8   9
 *         value {7,  2,  8,  9,  4, 22,  7,  1,  9, 10}
 *                \   /   \   /   \   /   \   /   \   /
 *                 \ /     \ /     \ /     \ /     \ /
 *                  V       V       V       V       V
 * after:  index  0   1   2   3   4   5   6   7   8   9
 *         value {0,  9,  0, 17, 26,  0,  8,  0,  0, 19} 
 */

package Arrays;

public class collapsePairs {
	public static void main(String[] args) {
		int[] arr = {7, 2, 8, 9, 4, 22, 7, 1, 9, 10};
		
		collapsePairs1(arr);
	}
	
	/* Adds adjacent #'s in pairs together.  If the sum is even, record the sum in the left
	 * of the pairs and 0 in the right.  Vice versa for odd.
	 * Pre:  Array is passed into the method
	 * Post: Array has been modified as described above
	 */
	private static void collapsePairs1(int[] arr) {
		//Go through the entire array.  Since we are using up 2 elements each pass,
		//we only need i to go through half the array.
		for(int i = 0; i < arr.length / 2; i++) {
			//Add adjacent elements together
			int temp = arr[2 * i] + arr[2 * i + 1];
			//If the added pair is even, store the new # in the left and a 0 on the right
			if(temp % 2 == 0) {
				arr[2 * i] = temp;
				arr[2 * i + 1] = 0;
			} 
			//If the added pair is odd, store the new # in the right and a 0 on the left
			else {
				arr[2 * i] = 0;
				arr[2 * i + 1] = temp;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
