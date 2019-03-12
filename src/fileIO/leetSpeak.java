/* Convert the contents of a file to leet speak and write the new text to a new file.
 * Leet Speak consists of the following chars being converted to new chars:
 * o:0, l:1, e:3, a:4, t:7, s:Z(at the end of a word only).  Wrap all words in parenthesis.
 * ex. years -> (y34rZ)
 */ 
 
package fileIO;

import java.util.*;
import java.io.*;

public class leetSpeak {
	public static void main(String[] args) {
		Scanner input = null;
		
		try {
			//Open our file and pass it to the readWriteFile method
			input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\leetSpeak.txt"));
						
			readWriteFile(input);
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
		finally {
			input.close();
		}
	}
	
	/* Opens a file for writing.  Reads a line at a time from the file that is passed in.  It
	 * then breaks the line up into tokens which are converted to strings.  It then creates a new
	 * string starting with ( and ending with ).  Certain chars are replaced in the new string.
	 * Once the new string is created, it writes the new word to a different file.
	 * Pre:  File is passed to method for reading
	 * Post: Words have been created with replaced chars and written to a seperate file
	 */
	private static void readWriteFile(Scanner input) {
		PrintWriter output = null;
		
		try {
			//Open file for writing
			output = new PrintWriter("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\writeLeetSpeak.txt");
			
			//Read 1 line at a time from the input file
			while(input.hasNextLine()) {
				String line = input.nextLine();
				//Break each line into string tokens
				StringTokenizer stok = new StringTokenizer(line);
				String word = "";
										
				//Go through each token from the current line
				while(stok.hasMoreTokens()) {
					String newStr = "";
					word = stok.nextToken().toString();
					newStr += "(";
					//Check each char and replace it w the following values if it matches
					for(int i = 0; i < word.length(); i++) {
						switch(word.charAt(i)) {
							case 'o':
								newStr += "0";
								break;
							case 'l':
								newStr += "1";
								break;
							case 'e':
								newStr += "3";
								break;
							case 'a':
								newStr += "4";
								break;
							case 't':
								newStr += "7";
								break;
							case 's':
								if(i == word.length() - 1)
									newStr += "Z";
								else
									newStr += "s";
								break;
							default:
								newStr += word.charAt(i);
						}
					}
					newStr += ")";
					//print new word to file
					output.print(newStr + " ");
				}
				//Once done with the current line, print a line break to put the next line on
				output.print("\n");
			}
		}
		catch(IOException ex) {
			System.out.println("Can't write to file!");
		}
		finally {
			output.close();
		}
	}
}