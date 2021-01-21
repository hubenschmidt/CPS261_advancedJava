package ReadingWithExceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingWithExceptions {
	String inputFileName;
	String outputFileName;
	Integer number_to_read;

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
	 */
	public void process(File inputFileName) {
		Scanner scanner = null;
		FileWriter writer = null;
		PrintWriter fo = null;

		try {
			scanner = new Scanner(inputFileName);
			handleMixedData(scanner, writer, fo);

		} catch (Exception e) {
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
		boolean invalidCount = false;
		int dataCounter = 1;
		ArrayList<Integer> inputFileValues = new ArrayList<Integer>();

		// get threshold for data file consumption
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
			invalidCount = true;
		}

		scanner.nextLine();

		// build array from fetched data, checking for input errors
		if (!invalidCount) {
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
			// emit warning if EOF has been reached
			if (!scanner.hasNext()) {
				System.err.println("WARNING: Input threshold exceeds file length. Fetching all availble data. "
						+ getInputFileName());
				System.out.println();
			}
		} else {
			while (scanner.hasNext()) {
				inputFileValues.add(scanner.nextInt());
			}
		}

		printOutputFile(inputFileValues, writer, fo);
		inputFileValues.clear();

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

		// format and print array of fetched data
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
