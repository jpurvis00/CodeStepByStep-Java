/*
 * 
 */
	
package fileIO;

import java.io.*;
import java.util.*;

public class reverseChunksInFile {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\reverseChunks.txt"));
			readFile(input);
			input.close();
		} catch(IOException ex) {
			System.out.println("Bad file name!");
		}
	}
	
	/* Read contents of the file passed in. */
	private static void readFile(Scanner fname) {
		while(fname.hasNextLine()) {
			String line = fname.nextLine();
			getTokens(line);
		}
	}
	
	/* Takes one line at a time from the file and reverses chunks for chars.
	 * We can assume that the line is in the following format for this problem:
	 * word int.  It then reversed int chars in the preceding word. Ex. Jeff 2 -> eJff
	 * Pre:  1 line is passed in from the file
	 * Post: int chars have been reversed
	 */
	private static void getTokens(String str) {
		StringTokenizer stok = new StringTokenizer(str);
		while(stok.hasMoreTokens()) {
			String name = stok.nextToken().toString();
			int revNum = Integer.parseInt(stok.nextToken());
			
			reverseChars(name, revNum);
		}
	}
	
	/*
	 * 
	 */
	private static void reverseChars(String name, int revNum) {
		String newStr = "";
		char ch = ' ';
		
		for(int i = revNum - 1; i >= 0; i--) {
			newStr += name.charAt(i);
		}
		
		System.out.println(newStr);
	}
}
