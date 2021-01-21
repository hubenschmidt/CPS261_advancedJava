package ReadingWithExceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingWithExceptions {
	String inputFileName;
	String outputFileName;
	Integer number_to_read;

	public void WalkFileTree(String path) throws IOException {
		Files.walk(Paths.get(path)).forEach(f -> process(f.toFile()));

	}

	public void process(File inputFileName) {
		Scanner scanner = null;
		FileWriter writer = null;
		PrintWriter fo = null;

		try {
			scanner = new Scanner(inputFileName);
			readMixedData(scanner, writer, fo);

		} catch (Exception e) { // what is approproate exception here?
			e.printStackTrace();

		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	public void readMixedData(Scanner scanner, FileWriter writer, PrintWriter fo) throws IOException {
		setOutputFileName(scanner.next());
		boolean invalidCount = false;
		int dataCounter = 0;
		ArrayList<Integer> inputFileValues = new ArrayList<Integer>();

		if (scanner.hasNextInt()) {
			set_number_to_read(scanner.nextInt());
			if (get_number_to_read() < 0) {
				System.out.println("Error: less than zero numbers to be read.");
				// then read as many integers as you find
			}
		} else {
			System.out.println("Error: invalid data count input: " + scanner.next());
			invalidCount = true;
		}
		scanner.nextLine();

		writer = new FileWriter(getOutputFileName());
		fo = new PrintWriter(writer);
		fo.print(getOutputFileName() + " created the following output:");

		if (!invalidCount) {
//			for (int i = 1; i < get_number_to_read(); i++) {

			while (scanner.hasNext() && dataCounter <= get_number_to_read()) {
				if (scanner.hasNextInt()) {
					inputFileValues.add(scanner.nextInt());
					dataCounter++;
				} else {
					System.out.println("Error: bad input data." + scanner.next());
				}
			}
//			}

			// If EOF has been reached
			if (!scanner.hasNext()) {
				System.out.println("End of file.");
			}
		}
		fo.print(inputFileValues);

		inputFileValues.clear();

		fo.flush();
		fo.close();

	}

	public static void main(String[] args) {
		ReadingWithExceptions app = new ReadingWithExceptions();

		for (String arg : args) {
			app.setInputFileName(arg);
			try {
				app.WalkFileTree(app.getInputFileName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public Integer get_number_to_read() {
		return number_to_read;
	}

	public void set_number_to_read(Integer number_to_read) {
		this.number_to_read = number_to_read;
	}

}
