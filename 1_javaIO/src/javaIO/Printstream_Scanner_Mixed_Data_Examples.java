package javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Printstream_Scanner_Mixed_Data_Examples {

	void readMixedData(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			String name = scanner.next();
			int homeRuns = scanner.nextInt();
			double battingAverage = scanner.nextDouble();

			printStream.printf("%s has %d home runs and has a %.3f batting average %n", name, homeRuns, battingAverage);
		}
	}

	void readMixedData2(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			try {
				String name = scanner.next();
				int homeRuns = scanner.nextInt();
				double battingAverage = scanner.nextDouble();

				printStream.printf("%s has %d ;home runs and has a %.3f batting avergae %n", name, homeRuns,
						battingAverage);
			} catch (InputMismatchException e) {
				System.out.println("Skipping line: " + e);
				scanner.nextLine(); // skip the remainder of the line
			}
		}
	}

	void readMixedData3(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			String name = scanner.next();
			int homeRuns = -1;
			if (scanner.hasNextInt())
				homeRuns = scanner.nextInt();
			else {
				// Note the following skips the bad input
				System.out.println("Bad home run input: " + scanner.next() + " defaulting to -1");

			}
			double battingAverage = -1;
			if (scanner.hasNextDouble())
				battingAverage = scanner.nextDouble();
			else {
				// Note the following skips the bad input
				System.out.println("Bad batting average: " + scanner.next() + " defaulting to -1");
			}

			printStream.printf("%s has %d home runs and has a %.3f batting average%n", name, homeRuns, battingAverage);
		}
	}

	void readMixedData4(Scanner scanner, PrintStream printStream) {
		while (scanner.hasNext()) {
			String name = scanner.nextLine();
			int homeRuns = -1;
			if (scanner.hasNextInt())
				homeRuns = scanner.nextInt();
			else {
				// Note the following skips the bad input
				System.out.println("Bad home run input: " + scanner.next() + " defaulting to -1");

			}
			double battingAverage = -1;
			if (scanner.hasNextDouble())
				battingAverage = scanner.nextDouble();
			else {
				// Note the following skips the bad input
				System.out.println("Bad batting average: " + scanner.next() + " defaulting to -1");
			}

			printStream.printf("%s has %d home runs and has a %.3f batting average%n", name, homeRuns, battingAverage);
			if (scanner.hasNextLine())
				scanner.nextLine(); // need to go to the next line
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

			// testing application

//			readMixedData(scanner, printStream);
			readMixedData4(scanner, printStream);

		} catch (FileNotFoundException e) {
			System.out.println("error: " + e);
		} finally {
			if (scanner != null)
				scanner.close();
			if (printStream != null) {
				printStream.close();
			}
		}
	}

	public static void main(String[] args) {
		Printstream_Scanner_Mixed_Data_Examples psme = new Printstream_Scanner_Mixed_Data_Examples();
		psme.process(args[0], args[1]);

	}

}
