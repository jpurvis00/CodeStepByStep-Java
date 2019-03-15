/* Read contents from a file.  The file contains a list of names.  Return the name that 
 * occurs the most.  We can assume that duplicate names will appear consecutively.  If
 * a name ties with another, return the previous name.
 * 
 * I'm sure this problem would be easier/nicer using a hash table or something similar.
 * I'll have to revisit this once I've studied those again.
 * 
 * I've been looking at maps/hashmaps.  I'll attempt to redo this problem using that
 * on the next project(printMostCommonName).
 */

package fileIO;

import java.util.*;
import java.io.*;

public class mostCommon {

	public static void main(String[] args) {
		//These are declared outside of the try block so that we can close the Scanner in the finally block
		Scanner input = new Scanner(System.in);
		System.out.print("Input file name: ");
		String fname = input.nextLine();
		BufferedReader rd = null;
		String name = "";
		
		try {
			rd = new BufferedReader(new FileReader(fname));
		
			while(true) {
				String line = rd.readLine();
				if(line == null)
					break;
				name = mostCommon1(line);
			}
			
			System.out.println("Most common name is: " + name);
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
		finally {
			input.close();
		}
	}

	/* Breaks a line of text up into tokens.  Compares the newest token to the elements in the 
	 * arrayList to see if it exists or not.  If it does, increment the # of times the name is found.
	 * If it is not found, add the new name to the arrayList.  The arrayList takes on the following
	 * form: Name:# of times name was found in file.
	 * Pre:  1 line of text is passed into the method from a file
	 * Post: ArrayList has been created and the names have been counted.  Returns the name that was found the most
	 */
	private static String mostCommon1(String str) {
		StringTokenizer stok = new StringTokenizer(str);
		boolean found = false;
		String finalName = "";
		
		//Do this for all tokens in the line
		while(stok.hasMoreTokens()) {
			//Put first value into ArrayList and put a 1 into the next arrayList spot to signify
			//how many times the name has occurred.
			if(finCount == 0) {
				nameList.add(stok.nextToken().toString());
				nameList.add("1");
				finCount++;
			}
			
			String name = stok.nextToken().toString();
			
			//Reset found and count each time through this loop
			found = false;
			count = 0;
			
			//Check to see if the new name already exists in the arrayList.  Change found to true
			//if found and add 1 to count
			for(int i = 0; i < nameList.size(); i++) {
				if(nameList.get(i).equals(name)) {
					found = true;
					count++;
				}
			}
				
			//If the name already exists, find the name in the arrayList and increment the next spot
			//in the arrayList to represents how many times the name has been found
			if(found) {
				for(int i = 0; i < nameList.size(); i++) {
					if(nameList.get(i).equals(name)) {
						int newCount = Integer.parseInt(nameList.get(i + 1));
						nameList.set(i + 1, String.valueOf(count + newCount));
					}
				}
			} 
			//The name is unique, add it to the arrayList along with a 1 since it's the first one
			else {
				nameList.add(name);
				nameList.add("1");
			}			
		}
		
		//ArrayList is complete, find the name that was found the most and return it
		int temp = 0;
		int tempi = 0;
		
		for(int i = 1; i < nameList.size(); i+=2) {
			if(i + 2 < nameList.size()) {
				if(Integer.parseInt(nameList.get(i)) > temp) {
					temp = Integer.parseInt(nameList.get(i));
					tempi = i;
				}
			}
		}
		finalName = nameList.get(tempi - 1);
		
		return finalName;
	}
	
	/** private instance variables */
	private static ArrayList<String> nameList = new ArrayList<String>();
	private static int finCount = 0;
	private static int count = 1;
}
