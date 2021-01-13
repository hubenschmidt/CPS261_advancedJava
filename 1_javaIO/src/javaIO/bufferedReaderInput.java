/**
 * The primitive data types in Java are: boolean, byte, char, short, int, long, float, and double. For each primitive data type, Java provides a wrapper class that allows the data to be represented as objects. The corresponding wrapper classes are: Boolean, Byte, Character, Short, Integer, Long, Float, and Double. The wrapper classes provide methods to perform certain data conversions, e.g. the method parseInt() of the Integer class can convert a String to an integer.


int num = Integer.parseInt ( "45 " );

How do we input data from the console? We will discuss the ways to input a String, an integer, and a real number. System.in is a pre-defined InputStream used with the console. Unfortunately this class does not have a method for simple input. But there is a java.io.BufferedReader class that has a method readLine(). A buffer is a region in memory where input from the terminal is stored until needed by the program. If you want to perform buffered input on the System.in stream you would pass the System.in object into the constructor.


BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

Once we have created a BufferedReader we can use its method readLine() to read one line of characters at a time from the keyboard and store it as a String object.


String inputString = input.readLine();
 */

package javaIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bufferedReaderInput {

	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
