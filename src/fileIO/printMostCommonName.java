/* This is basically the same problem as mostCommon.  Only difference is we are printing the name
 * and how many times it occurred in the file.  
 * 
 * I looked up how to use a LinkedHashMap and used it.  Makes the code much more simple. 
 */

package fileIO;

import java.io.*;
import java.util.*;

public class printMostCommonName {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fname = input.nextLine();
		BufferedReader rd = null;
		int numNames = 0;
		
		try {
			rd = new BufferedReader(new FileReader(fname));
			while(true) {
				String line = rd.readLine();
				if(line == null)
					break;
				numNames = printMostCommon(line);
			}
			
			//Print out the LinkedHashMap
			//System.out.println(namesMap);
						
			//Find the name that was in the tile the most.  If more than 1 tie,
			//output the first one that was in the file.
			//Make a hashmap called maxEntry.  This will store the key/value of the highest value
			Map.Entry<String, Integer> maxEntry = null;
			
			//Create another hashmap called entry and store all entries from namesMap 1 at a time in it
			for(Map.Entry<String, Integer> entry : namesMap.entrySet()) {
				//If null, it's the first time through and put he first key/value in the maxEntry hashmap.
				//If !null, compare the entry key:value to the maxEntry key:value.
				if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
					maxEntry = entry;
				}
			}
			
			System.out.println("Most common name: " + maxEntry.getKey() + ", " + maxEntry.getValue());
			System.out.println("# of unique names: " + numNames);
		}
		catch(IOException ex) {
			System.out.println("Bad file name!");
		}
		finally {
			input.close();
		}
	}
	
	/* Puts all unique names in a hashmap as keys and updates the # of times
	 * they occur in the file as the values.
	 * Pre:  1 line of the text file is passed to the method
	 * Post: All names have been extracted from the line and insterted into the hashmap. 
	 * 		 If the name exists more than once, the value for that key has been incremented by 1. 
	 */
	private static int printMostCommon(String str) {
		int numNames = 0;
		StringTokenizer stok = new StringTokenizer(str);
		
		//Do this for each token in the string
		while(stok.hasMoreTokens()) {
			String name = stok.nextToken().toString();
			//If name is not in the hashmap, insert it w the value of 1
			if(!namesMap.containsKey(name))
				namesMap.put(name, 1);
			//If name is in the hashmap, get the value of the key and add 1 signifying that the 
			//key has been found an additional time
			else
				namesMap.put(name, namesMap.get(name) + 1);
		}
				
		numNames = namesMap.size();
		
		return numNames;
	}
	
	/** private instance variables */
	private static Map<String, Integer> namesMap = new LinkedHashMap<>();
}
