/* This class will check two dates from a file and see if they are 1 month or more
 * apart.  We are assuming that there are only 2 dates on each line of the file in 
 * the following format: month year....ex: 9 4 10 16
 */

package fileIO;

import java.io.*;
import java.util.*;
import java.lang.*;

public class checkDates {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("C:\\Users\\jpurvis\\git\\CodeStepByStep-Java\\src\\fileIO\\dates.txt"));
			readFile(input);
			input.close();
			compareDates();
			//printResults();
		} catch(IOException ex) {
			System.out.println("Bad file name!");
		}
	}
	
	/* Reads each line of a file. */
	private static void readFile(Scanner input) {
		while(input.hasNextLine()) {
			String line = input.nextLine();
			storeValues(line);
		}
	}
	
	/* Takes a line from a file and stores each int in an arrayList.
	 * Pre:  1 line from the file is passed in 
	 * Post: All 4 values from the line are stored in the arrayList
	 */
	private static void storeValues(String str) {
		StringTokenizer stok = new StringTokenizer(str);
		
		while(stok.hasMoreTokens()) {
			dateList.add(Integer.parseInt(stok.nextToken()));
		}
	}
	
	/* Compares two dates to see if they are 1 month apart or not.
	 * Pre:  All dates have been stored in the arrayList(dateList)
	 * Post: All dates from the file have been compared.  Dates are passed to the 
	 *       printResults method as well as a boolean value stating whether or not 
	 *       they dates are mone apart
	 */
	private static void compareDates(){
		int monthDiff = 0;
		//increase i by 4 every time through this loop so that we compare every other month in dateList
		for(int i = 0; i < dateList.size(); i += 4) {
			//check to make sure i doesn't go out of bounds
			if(i + 2 < dateList.size()) {
				//Finds out how many months apart the month dates are.  Take the abs value in so we don't have to 
				//worry about the order during subtraction
				monthDiff = Math.abs(dateList.get(i) - dateList.get(i + 2));
				
				//We know that there is more than one month between the dates, print out a true msg
				if(monthDiff > 1) 
					printResults(dateList.get(i), dateList.get(i +1), dateList.get(i + 2), dateList.get(i+3), true);
				//Month is an adjacent month, ex. jan - feb
				else if (monthDiff == 1){
					int dayDiff = 0;
					//If month 1 comes before month 2, subtract day 2 from day 1, this will give u a neg result
					if(dateList.get(i) < dateList.get(i + 2))
						dayDiff = dateList.get(i + 1) - dateList.get(i + 3);
					//If month 2 comes before month 1, subtract day 1 from day 2, this ensures a neg result if they are a month apart
					else
						dayDiff = dateList.get(i + 3) - dateList.get(i + 1);
					
					//Neg result from above means the dates are at least 1 month apart
					if(dayDiff < 1) 
						printResults(dateList.get(i), dateList.get(i +1), dateList.get(i + 2), dateList.get(i+3), true);
					else
						printResults(dateList.get(i), dateList.get(i +1), dateList.get(i + 2), dateList.get(i+3), false);
				}
				else {//monthDiff = 0, month is the same month, print out false statement
					printResults(dateList.get(i), dateList.get(i +1), dateList.get(i + 2), dateList.get(i+3), false);					
				}
			}
		}
	}
	
	/* Prints the results of the date comparisons. */
	private static void printResults(int firstMonth, int firstDay, int secMonth, int secDay, boolean trueFalse) {
		if(trueFalse)
			System.out.println(firstMonth + "/" + firstDay + " and " + secMonth + "/" + secDay + " differ by one full month or more!");
		else
			System.out.println(firstMonth + "/" + firstDay + " and " + secMonth + "/" + secDay + " are within one month of each other!");
	}
	
	/** private instance variables */
	private static ArrayList<Integer> dateList = new ArrayList<Integer>();
}
