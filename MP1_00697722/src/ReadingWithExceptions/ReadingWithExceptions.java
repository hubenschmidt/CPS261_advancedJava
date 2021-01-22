package ReadingWithExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author William Hubenschmidt
 * 
 * 
 */

public class ReadingWithExceptions {
	String inputFileName;
	String outputFileName;
	int number_to_read;
	boolean invalidCount = false;
	int dataCounter = 1;

	/**
	 * Getters
	 * 
	 * @return
	 */
	public String getInputFileName() {
		return inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public Integer get_number_to_read() {
		return number_to_read;
	}

	public boolean getInvalidCount() {
		return invalidCount;
	}

	/**
	 * Setters
	 * 
	 * @param
	 */
	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public void set_number_to_read(Integer number_to_read) {
		this.number_to_read = number_to_read;
	}

	public void setInvalidCount(boolean invalidCount) {
		this.invalidCount = invalidCount;
	}

	/**
	 * Scan all files in host directory.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void WalkFileTree(String path) throws IOException {
		Files.walk(Paths.get(path)).forEach(f -> process(f.toFile()));
	}

	/**
	 * Initialize Scanner, FileWriter and PrintWriter objects.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public void process(File inputFileName) {
		Scanner scanner = null;
		FileWriter writer = null;
		PrintWriter fo = null;
		try {
			scanner = new Scanner(inputFileName);
			handleMixedData(scanner, writer, fo);

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (scanner != null)
				scanner.close();
		}
	}

	/**
	 * Handles mixed data from input file and invalid tokens.
	 * 
	 * @param scanner
	 * @param writer
	 * @param fo
	 * @throws IOException
	 */
	public void handleMixedData(Scanner scanner, FileWriter writer, PrintWriter fo) throws IOException {
		setOutputFileName(scanner.next());
		int dataCounter = 1;
		ArrayList<Integer> inputFileValues = new ArrayList<Integer>();
		getThreshHold(scanner);
		scanner.nextLine();
		// build array from fetched data, checking for input errors
		if (!getInvalidCount()) {
			while (scanner.hasNext() && dataCounter <= get_number_to_read()) {
				if (!scanner.hasNextInt()) {
					System.err.println("ERROR: " + scanner.ioException() + " input. "
							+ "Data is invalid. Input discarded: " + scanner.next() + " " + getInputFileName());
					System.out.println();
					inputFileValues.add(scanner.nextInt());
					dataCounter++;
				} else if (scanner.hasNextInt()) {
					inputFileValues.add(scanner.nextInt());
					dataCounter++;
				} else {
					System.err.println("ERROR: " + scanner.ioException() + " input " + scanner.next()
							+ ". Data is invalid. Input discarded: " + scanner.next() + " " + getInputFileName());
					System.out.println();
				}
			}
			checkForEOF(scanner);
		} else {
			while (scanner.hasNext()) {
				inputFileValues.add(scanner.nextInt());
			}
		}
		printOutputFile(inputFileValues, writer, fo);
		inputFileValues.clear();
	}

	/**
	 * Checks for integer at beginning of input file to determine total number of
	 * integers to fetch.
	 * 
	 * @param scanner
	 */
	public void getThreshHold(Scanner scanner) {
		if (scanner.hasNextInt()) {
			set_number_to_read(scanner.nextInt());
			if (get_number_to_read() < 0) {
				System.err.println("ERROR: " + scanner.ioException() + " input. Threshold is less than zero. "
						+ getInputFileName());
			}
		} else {
			System.err.println("ERROR: " + scanner.ioException() + " input "
					+ ". Input threshold is not a valid number. Fetching all available data. Input discarded: "
					+ scanner.next() + " " + getInputFileName());
			setInvalidCount(true);
		}
	}

	/**
	 * Checks for end of file.
	 * 
	 * @param scanner
	 */
	public void checkForEOF(Scanner scanner) {
		// emit warning if EOF has been reached
		if (!scanner.hasNext()) {
			System.err.println(
					"WARNING: Input threshold exceeds file length. Fetching all availble data. " + getInputFileName());
			System.out.println();
		}
	}

	/**
	 * Prints formatted data to output files.
	 * 
	 * @param inputFileValues
	 * @param writer
	 * @param fo
	 * @throws IOException
	 */
	public void printOutputFile(ArrayList<Integer> inputFileValues, FileWriter writer, PrintWriter fo)
			throws IOException {
		writer = new FileWriter(getOutputFileName());
		fo = new PrintWriter(writer);
		fo.print(getOutputFileName() + " created the following output:\n");
		for (int i = 0; i < inputFileValues.size(); i++) {
			if (i % 10 == 0 && i > 0) {
				fo.println();
			}
			fo.print(inputFileValues.get(i) + " ");
		}
		fo.flush();
		fo.close();

	}

	public static void main(String[] args) {
		ReadingWithExceptions app = new ReadingWithExceptions();
		for (String arg : args) {
			app.setInputFileName(arg);
			try {
				app.WalkFileTree(app.getInputFileName());
			} catch (NoSuchFileException e) {
				e.printStackTrace();
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println();
			}
		}
	}
}
