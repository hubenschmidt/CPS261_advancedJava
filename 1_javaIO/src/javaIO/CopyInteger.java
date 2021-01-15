package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CopyInteger {

	void copyInts(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			int x = scanner.nextInt();
			printStream.println(x);
		}
	}

	void copyInts2(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			try {
				int x = scanner.nextInt();
				printStream.println(x);
			} catch (InputMismatchException e) {
				// Note the following skips over the bad input
				System.out.println(e + " bad integer: " + scanner.next());

			}
		}
	}

	void copyInts3(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			int x = -1;
			if (scanner.hasNextInt()) {
				x = scanner.nextInt();
				printStream.println(x);
			} else {
				// Note the following skips over the bad input
				System.out.println(" bad integer: " + scanner.next());
			}
		}
	}

	void process(String inputFileName, String outputFileName) {
		Scanner scanner = null;
		PrintStream printStream = null;

		try {
			FileInputStream fi = new FileInputStream(inputFileName);
			scanner = new Scanner(fi);
			FileOutputStream fo = new FileOutputStream(outputFileName);

			printStream = new PrintStream(fo);

			// application testing:

			// copyInts(scanner, printStream);
			// copyInts2(scanner, printStream);
			copyInts3(scanner, printStream);

		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		}

		finally {
			if (scanner != null)
				;
			scanner.close();
			if (printStream != null)
				;
			printStream.close();
		}
	}

	public static void main(String[] args) {
		CopyInteger ci = new CopyInteger();
		ci.process(args[0], args[1]);
	}

}
