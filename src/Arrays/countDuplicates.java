/* Count the # of duplicates in an array. */

package Arrays;

public class countDuplicates {
	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 4, 7, 1, 1, 9, 2, 3, 4, 1};
		
		System.out.println("Numb of duplicates: " + countDupes(arr));
	}
	
	/* Checks the array and find the # of duplicate #'s in the array.
	 * The first occurence does not count.  If the array contained 1, 1, 1, 
	 * then the dup count would be 2.  
	 * Pre:  An array in passed in
	 * Post: # of duplicates is returned
	 */
	private static int countDupes(int[] a) {
		int dup =  0;
		
		for(int i = 0; i < a.length; i++) {
			int count = 0;
			for(int j = i + 1; j < a.length; j++) {
				if(a[i] == a[j])
					count++;
			}
			if(count >= 1)
				dup++;
		}
		return dup;
	}
}
