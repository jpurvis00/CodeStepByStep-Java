/*  Write a method named hasMirrorTwice that accepts two arrays of integers a1 and a2
 *  as parameters and returns true if a1 contains all the elements of a2 in reverse 
 *  order at least twice (and false otherwise). For example, if a2 stores the 
 *  elements {1, 2, 3} and a1 stores the elements {6, 3, 2, 1, 4, 1, 3, 2, 1, 5}, 
 *  your method would return true.
 *  
 *  Assume that both arrays passed to your method will 
 *  have a length of at least 1. This means that the shortest possible mirror will be 
 *  of length 1, representing a single element (which is its own mirror). A sequence 
 *  that is a palindrome (the same forwards as backwards) is considered its own mirror 
 *  and should be included in your computations. For example, if a1 is {6, 1, 2, 1, 4, 1, 2, 1, 5} 
 *  and a2 is {1, 2, 1}, your method should return true. The two occurrences of 
 *  the mirror might overlap, as shown in the fourth sample call below. 
 */

package Arrays;

public class hasMirrorTwice {
	public static void main(String[] args){
		int[] a1 = {6, 1, 2, 1, 3, 1, 3, 2, 1, 5};
		int[] a2 = {1, 2}; 	
		System.out.println("Values mirrored: " + hasMirrorTwice1(a1, a2)); //returns true
		
		int[] a3 = {5, 8, 4, 18, 5, 42, 4, 8, 5, 5};
		int[] a4 = {4, 8, 5}; 	
		System.out.println("Values mirrored: " + hasMirrorTwice1(a3, a4)); //returns false
		
		int[] a5 = {6, 3, 42, 18, 12, 5, 3, 42, 3, 42};
		int[] a6 = {42, 3}; 	
		System.out.println("Values mirrored: " + hasMirrorTwice1(a5, a6)); //returns true
		
		int[] a7 = {6, 1, 2, 4, 2, 1, 2, 4, 2, 1, 5};
		int[] a8 = {1, 2, 4, 2, 1}; 	
		System.out.println("Values mirrored: " + hasMirrorTwice1(a7, a8)); //returns true
		
		int[] a9 = {0, 0};
		int[] aa = {0}; 	
		System.out.println("Values mirrored: " + hasMirrorTwice1(a9, aa)); //returns true
		
		int[] ab = {8, 9, 2, 1};
		int[] ac = {5, 7, 1, 2, 9, 8};
		System.out.println("Values mirrored: " + hasMirrorTwice1(ab, ac)); //returns false
	}
	
	/* Checks to see if b exists in a in reversed order at least twice.  See
	 * description at top for more detail.
	 * Pre:  Two int arrays are passed in the method
	 * Post: Returns true if it is found and false if it isn't
	 */
	private static boolean hasMirrorTwice1(int[] a, int[] b) {
		for(int i = 0; i < a.length; i++) {
			for(int j = b.length; j >= 0; j--) {
				if(b[j] == a[i])
			}
		}
		return true;
	}
}