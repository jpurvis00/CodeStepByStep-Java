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
	
	/* Takes one line of text from a file and breaks it into tokens.  These tokens
	 * represent a word and the # of chars to reverse in each chunk.  It will also
	 * test to see if any more tokens exist and set a boolean to true if we are on 
	 * the last token.
	 * Pre:  1 line of text is passed in from a file
	 * Post: 2 tokens and a boolean are passed to the reverseChars method 
	 */
	private static void getTokens(String str) {
		StringTokenizer stok = new StringTokenizer(str);
		boolean stop = false;
		
		/* We can assume that the file is in the following format: word #.  This allows us
		 * to assign the 1st token to name and the 2nd token to revNum.
		 */
		while(stok.hasMoreTokens()) {
			String name = stok.nextToken().toString();
			int revNum = Integer.parseInt(stok.nextToken());
			
			//If there are no more tokens, set stop to true so that we know when to print a \n to 
			//keep the format of the file.
			if(!stok.hasMoreTokens())
				stop = true;
			
			reverseChars(name, revNum, stop);
		}
	}
	
	/* Takes two tokens at a time from the file and reverses chunks for chars.
	 * It reverses int chars in the preceding word. Ex. Jeff 2 -> eJff
	 * Pre:  2 tokens are passed in from the file along with a boolean value to tell when to print a new line char
	 * Post: int chars have been reversed in the passed in word
	 */
	private static void reverseChars(String name, int revNum, boolean stop) {
		String newStr = "";
		
		//If the int does not divide evenly with the length of the word, store the # of remaining chars.
		//These will be added at the end of the word preserving order.
		int leftOver = name.length() % revNum;
		
		//I want to run through this loop name.length / revNum.  If the word is 10 chars long and the 
		//reverse int is 4, run through the loop 2x.  leftOver would be 2 in this case.
		for(int i = 1; i <= name.length() / revNum; i++) {
			//This loop reverses chars in revNum chunks.  Used with the previous for loop and the prev ex,
			//we will reverse the first 4 char, then move onto the next 4 chars
			for(int j = (revNum * i) - 1; j >= (revNum * i) - revNum; j--) {
				newStr += name.charAt(j);
			}
		}
				
		//If the int does not divide evenly with the length of the word, append the remaining chars to the new string 
		if(leftOver != 0) {
			for(int i = name.length() - leftOver; i < name.length(); i++) {
				newStr += name.charAt(i);
			}
		}
		
		//Print out all words from the same line in the file
		System.out.print(newStr + " ");
		
		//When we are on the last token from the getTokens method, start a new line for the next line in the file
		if(stop)
			System.out.print("\n");
		
	}
}
