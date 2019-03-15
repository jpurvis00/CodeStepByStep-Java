/* Read the contents of a file.  Output how many words, average length,
 * and the # of unique letters. 
 */

package fileIO;

import java.util.*;
import java.io.*;

public class wardStats {
	public static void main(String[] args) {
		BufferedReader rd = null;
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.print("Enter file name: ");
			String fname = input.nextLine();
			rd = new BufferedReader(new FileReader(fname));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				wordStats1(line);
			}
			
			System.out.println("Total words    = " + wordCount);
			System.out.println("Average length = " + numChars / wordCount);
			System.out.println("Unique letters = " + uLetters.size());
			rd.close();
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
		finally {
			input.close();
		}
	}
	
	/* Takes a line from a file and breaks it up into tokens.  It then 
	 * counts the words and chars of that line.  It also sends each word to the uniqueChars
	 * method.
	 * Pre:  1 line of a file is passed to method
	 * Post: wordCount has been updated, numChars has been updated.  All words from the line 
	 *  	 have been passed to uniqueChars method.
	 */
	private static void wordStats1(String str) {
		StringTokenizer stok = new StringTokenizer(str);
		String word = "";
		
		wordCount += stok.countTokens();
		
		while(stok.hasMoreTokens()) {
			word = stok.nextToken().toString();
			uniqueChars(word);
			numChars += word.length();
		}
	}
	
	/* Looks at a word and determines how many of the chars are unique.  A char
	 * is unique as long as it appears at least once in the file.  We don't count
	 * each occurrence.
	 * Pre:  1 word is passed to method
	 * Post: Each letter will be put into a hashmap so that we only get unique letters.
	 */
	private static void uniqueChars(String word) {
		for(int i = 0; i < word.length(); i++) {
			if(Character.isLetter(word.charAt(i))) {
				if(!uLetters.containsKey(word.charAt(i))) {
					uLetters.put(Character.toLowerCase(word.charAt(i)), 1);
				}
			}
		}
	}
	
	/** private instance vars */
	private static int wordCount = 0;
	private static double numChars = 0;
	private static Map<Character, Integer> uLetters = new HashMap<>();
}
