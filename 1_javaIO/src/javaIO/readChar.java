package javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * performance increase results from reading from an array of characters instead
 * of directly from file, one character at a time.
 * 
 * Reading an array of characters at a time is faster than reading a single
 * character at a time from a Java FileReader. The difference can easily be a
 * factor 10 or more in performance increase, by reading an array of characters
 * rather than reading a single character at a time.
 * 
 * The exact speedup gained depends on the size of the char array you read, and
 * the OS, hardware etc. of the computer you are running the code on. You should
 * study the hard disk buffer sizes etc. of the target system before deciding.
 * However buffer sizes of 8KB and up will give a good speedup. However, once
 * your char array exceeds the capacity of the underlying OS and hardware, you
 * won't get a bigger speedup from a bigger char array.
 * 
 * You will probably have to experiment with different byte array size and
 * measure read performance, to find the optimal char array size.
 * 
 * @author williamroymbp
 *
 */

public class readChar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("input.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] destination = new char[1024];
		try {
			int charsRead = fileReader.read(destination, 0, destination.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fileReader.close();
		}

	}

}
