/* Read numbers from a file and return the average.  We can assume that the 
 * file format contains one number per line and nothing else.  If the file is
 * empty, return 0.0.
 */

package fileIO;

import java.io.*;
import java.util.*;

public class averageValueInFile {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\aveValue.txt"));
			
			storeFileArray(input);
			averageValue();
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
	}
	
	/* Reads the file line by line and stores the values in and arrayList.
	 * Pre:  File is passed into method
	 * Post: All values have been stored in an arrayList
	 */
	private static void storeFileArray(Scanner fname) {	
		while(fname.hasNextLine()) {
			doubleList.add(fname.nextDouble());
		}
	}
	
	/* Calculates the average of the #'s from a file whose format is one # per line.
	 * Pre:  An arrayList has been created with all the values in the file
	 * Post: The average of the #'s in the arrayList is printed.
	 */
	private static void averageValue() {
		double average = 0;
		
		if(doubleList.size() > 0) {
			for(int i = 0; i < doubleList.size(); i++) {
				average += doubleList.get(i);
			}
			
			System.out.println("Average: " + (average /= doubleList.size()));
		} else
			System.out.println("Average: 0.0");
	}
	
	/** private instance variables */
	private static ArrayList<Double> doubleList = new ArrayList<Double>();
}
