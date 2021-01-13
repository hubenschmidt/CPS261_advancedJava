package javaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//You can add transparent, automatic reading and buffering of an array of bytes from a FileReader using a Java BufferedReader . The BufferedReader reads a chunk of chars into a char array from the underlying FileReader. You can then read the bytes one by one from the BufferedReader and still get a lot of the speedup that comes from reading an array of chars rather than one character at a time. Here is an example of wrapping a Java FileReader in a BufferedReader :

public class bufferedReader2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader input = null;
		try {
			input = new BufferedReader(new FileReader("input.txt"), 1024 * 1024 /* buffer size */
			);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
		;

	}

}
