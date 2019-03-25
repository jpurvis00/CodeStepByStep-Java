/* Write a method named collapse that accepts an array of integers as a parameter 
 * and returns a new array where each pair of integers from the original array 
 * has been replaced by the sum of that pair. For example, if an array called a 
 * stores {7, 2, 8, 9, 4, 13, 7, 1, 9, 10}, then the call of collapse(a) should 
 * return a new array containing {9, 17, 17, 8, 19}. The first pair from the original 
 * list is collapsed into 9 (7 + 2), the second pair is collapsed into 17 (8 + 9), and so on.
 * 
 * If the list stores an odd number of elements, the final element is not collapsed. 
 * For example, if the array had been {1, 2, 3, 4, 5}, then the call would return {3, 7, 5}. 
 * Your method should not change the array that is passed as a parameter.
 */

package Arrays;

public class collapse {
	public static void main(String[] args) {
		int[] list = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
		int[] list2 = {1, 2, 3, 4, 5};
		
		collapseArray(list);
		collapseArray(list2);
	}
	
	/* Collapses an array be adding 2 array elements and putting them into a new
	 * array.  i + (i+1) will be added together.
	 * Pre:  An array is passed into the method
	 * Post: A new array is created and printed
	 */
	private static void collapseArray(int[] list) {
		int length = 0;
	
		//If orig array has an even # of items, the new array will have a length
		//of half that
		if(list.length % 2 == 0)
			length = list.length / 2;
		//Orig array has an odd # of items, the new array will have a length of
		//half that + 1
		else
			length = list.length / 2 + 1;
			
		//Create new array with new size
		int[] newArray = new int[length];
	
		//Go through loop newArray.length times
		for(int i = 0; i < newArray.length; i++) {
			//If the newArray length is even, add together 2 values
			if(list.length % 2 == 0)
				newArray[i] = list[2 * i] + list[2 * i + 1];
			//newArray length is not even.  We need this so that i does not go out of range.
			//Add consecutive elements together until we only have one left.  If there is only 
			//1 int left, grab it and stick it at the end of the newArray.
			else {
				if(i + 1 < newArray.length)
					newArray[i] = list[2 * i] + list[2 * i + 1];
				else
					newArray[i] = list[list.length - 1];
			}
		}
		
		for(int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + " ");
		}
		System.out.println("\n");
	}
}
