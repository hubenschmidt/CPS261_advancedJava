package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIODemo {

	public static void main(String[] args) throws IOException {

		FileReader fileIO = null;
		FileWriter fileOut = null;
		Scanner scannerIO = null;
		PrintWriter printOut = null;

		int c;

		try {
			fileIO = new FileReader("input.txt");
			fileOut = new FileWriter("output.txt");
			scannerIO = new Scanner(new FileInputStream("input.txt"));
			printOut = new PrintWriter(new FileOutputStream("other_output.txt", true)); // true parameter appends
																						// instead over overwriting
			c = fileIO.read();

			while (c != -1) { // while not at end of file
				System.out.println((char) c); // prints each character from input file, one line at a time.
				fileOut.write(c);
				c = fileIO.read();
			}

			while (scannerIO.hasNext()) { // if scanner has a next chunk of string
//				System.out.println(scannerIO.next()); // print each string one line at a time from input file.
				printOut.println(scannerIO.next()); // converts characters using PrintWriter method
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fileIO.close();
			scannerIO.close();
			fileOut.close();
			printOut.close();
		}

	}

}
