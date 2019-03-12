/* Read lines from a file.  Flip alternating lines and flip case on the lines.
 * First line should be all caps.  Second line should be all lower case.   
 */

package fileIO;

import java.io.*;
import java.util.*;

public class flipLines {

	public static void main(String[] args) {
		/* Opening the scanner and file outside of the try loop allows us to access the file 
		 * var so that we can ref it in our catch loop.
		 */
		while(true) {
			System.out.print("Enter file name: ");
			Scanner input = new Scanner(System.in);
			File file = new File(input.nextLine());
			int totLines = 0;
			
			try {
				input = new Scanner(file);
				totLines = flipLines1(input);
				input.close();
				System.out.println("Total # of lines: " + totLines);
				break;
			}
			catch(IOException ex) {
				System.out.println("Unable to open input file " + file);
			}
		}
	}
	
	/* Gets two lines from the file at a time and flips them.  First line 
	 * is converted to all caps and 2nd line is converted to all lower case.
	 * This is done for every other line that exists.  
	 * Pre:  File is passed into method
	 * Post: All new lines have been printed to output
	 */
	private static int flipLines1(Scanner input) {
		String line1 = "";
		String line2 = "";
		int totLines = 0;
		
		while(input.hasNextLine()) {
			line1 = input.nextLine().toLowerCase();
			totLines++;
						
			//Even though we are in the loop bc there is a next line, there is no 
			//guarantee that there are 2 more lines. Only assign and print if there is a 2nd line.
			if(input.hasNextLine()) {
				line2 = input.nextLine().toUpperCase();
				System.out.println(line2);
				totLines++;
			} else
				//# of lines is odd, last line of odd should always be uppercase
				line1 = line1.toUpperCase();
			
			System.out.println(line1);
		}
		return totLines;
	}
}
