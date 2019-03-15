/* Write a variable declaration and for loop necessary to create 
 * and initialize an integer array named squares that contains the following values:
 * 0 1 4 9 16 25 36 49 64 81 100
 */

package Arrays;

public class squaredArray {
	public static void main(String[] args) {
		int[] intArr = new int[11];
		
		for(int i = 0; i < 11; i++) {
			intArr[i] = i * i;
		}
		
		for(int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
	}
}
