package exceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * Generally, checked exceptions denote error scenarios which are outside the
 * immediate control of the program. They occur usually interacting with outside
 * resources/network resources e.g. database problems, network connection
 * errors, missing files etc.
 *
 */

public class checkedException {
	public static void main(String[] args) {
		try {
			FileReader file = new FileReader("somefile.txt");
		} catch (FileNotFoundException e) {
			// Alternate logic
			e.printStackTrace();

			System.out.println(e + " - File not found!");
		}
	}

}
