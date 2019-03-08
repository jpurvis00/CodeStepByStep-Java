/* Takes a line of text and breaks it up into tokens.  It then changes
 * the tokens into strings.  We check each char to see if it's the same
 * as the next char.  If it's the same skip adding it to our new string.
 */

package fileIO;

import java.io.*;
import java.util.*;

public class removeDuplicatesFromFile {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\removeDupes.txt"));
			
			readFile(input);
			
			input.close();
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
	}
	
	/* Reads the user specified file line by line
	 * Pre:  Scanner for the file is passed in
	 * Post: Passes one line at a time to the removeDups method
	 */
	private static void readFile(Scanner input) {
		while(input.hasNext()) {
			String line = input.nextLine();
			
			removeDups(line);			
		}
	}
	
	/* Takes a line of text and breaks it up into tokens.  It then changes
	 * the tokens into strings.  We check each char to see if it's the same
	 * as the next char.  If it's the same skip adding it to our new string.
	 * Pre:  1 line of text from the file is passed in
	 * Post: All duplicate chars are removed from the word and a new word has
	 * 	  	 been created
	 */
	private static void removeDups(String str) {
		StringTokenizer stok = new StringTokenizer(str);
				
		while(stok.hasMoreTokens()) {
			String word = stok.nextToken().toString();
			String newStr = "";
			
			//Check every char in the word
			for(int i = 0; i < word.length(); i++) {
				//make sure that we are not checking an i + 1 that is out of bounds
				if(i + 1 < word.length()) {
					if(word.charAt(i) != word.charAt(i + 1)) {
						newStr += word.charAt(i);
					}
				} 
				//i + 1 is out of bounds meaning we are at the last char of the word.
				//Add it to our new word.
				else {
					newStr += word.charAt(i);
				}
			}
			System.out.print(newStr + " ");
		}
		System.out.print("\n");
	}
}
