/* Open a file and report the length of each line, the number of 
 * lines in the file, the length of the longest line, and the average
 * characters per line. 
 */

package fileIO;

import java.util.*;
import java.io.*;

public class inputStats {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\inputStats.txt"));
			inputStats1(input);
			input.close();
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
	}
	
	/* Reads contens of a file and computes length of each line, the number of 
	 * lines in the file, the length of the longest line, and the average
	 * characters per line. 
	 * Pre:  File is passed to method
	 * Post: Results are printed.  
	 */
	private static void inputStats1(Scanner input) {
		int lineCount = 0;
		int longest = 0;
		double average = 0.0;
		int totalChars = 0;
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			int lineLength = line.length();
			
			totalChars += lineLength;
			lineCount++;
			average = (double)totalChars / lineCount;
			
			System.out.println("Line " + lineCount + " has " + lineLength + " chars");
			
			if(lineLength > longest)
				longest = lineLength;
		}
		System.out.println(lineCount + " lines; longest = " + longest + ", average = " + average);
	}
}
