/* Read a series of coin flips from a file.  We can assume that the only data present in the
 * file is: H T Heads Tails.  This is case sensitive.  Determine how many heads have been 
 * flipped, calculate the % and print "You win!" if >= than 50 and "You lose!" if < 50.
 */

package fileIO;

import java.io.*;
import java.util.*;

public class coinFlip {

	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\headsTails.txt"));
			headsTails(input);
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
	}

	/* Reads all lines from the file.  Tallies how many heads have been flipped. Tallies
	 * heads percentage.  Prints "You win!" if heads is >= 50.  
	 * Pre:  File is passed into method
	 * Post: Results are printed for the user
	 */
	private static void headsTails(Scanner input) { 
		int headCount = 0;
		int totCount = 0;
		int perc = 0;
		
		while(input.hasNext()) {
			totCount++;

			//Convert all tokens to strings and to lower case.  Now we can check if it's head without
			//worrying about case.
			String str = input.next().toString().toLowerCase();
			//Only get the first char of the string.  That's all we care about since we are only looking for (h)eads
			if(str.charAt(0) == 'h')
				headCount++;
		}
		
		perc = (headCount * 100) / totCount;
		
		if(perc >= 50)
			System.out.println(headCount + " heads (" + perc + "%)\nYou win!");
		else
			System.out.println(headCount + " heads (" + perc + "%)\nYou lose!");
	}
}
