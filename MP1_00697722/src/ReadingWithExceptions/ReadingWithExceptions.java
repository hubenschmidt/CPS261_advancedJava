package ReadingWithExceptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadingWithExceptions {
	String inputFileName;
	String outputFileName;
	Integer number_to_read;

	public void WalkFileTree(String path) throws IOException {
		Files.walk(Paths.get(path)).forEach(f -> process(f.toFile()));

	}

	public void process(File inputFileName) {
//		System.out.println(file);
		Scanner scanner = null;
		PrintWriter fo = null;

		try {
			scanner = new Scanner(inputFileName);

//			printStream = new PrintStream();
			readMixedData(scanner, fo);

			// FileOutputStream fo = new FileOuputStream(outputFileName);

		} catch (Exception e) { // what is approproate exception here?
			System.out.println("error: " + e);

		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	public void readMixedData(Scanner scanner, PrintWriter fo) throws IOException {
		setOutputFileName(scanner.next());

		if (scanner.hasNextInt()) {
			set_number_to_read(scanner.nextInt());
			if (get_number_to_read() < 0) {
				System.out.println("Error: less than zero numbers to be read.");
				// then read as many integers as you find
			}
		} else {
			System.out.println("Error: bad count input: " + scanner.next());
		}
		scanner.nextLine();
		fo = new PrintWriter(new FileOutputStream(getOutputFileName()));

		for (int i = 1; i <= get_number_to_read(); i++) {
			if (!scanner.hasNextInt()) {
				System.out.println("Error: bad data input.");
				scanner.next();
			} else {
				// determine why code is not printing to file:
//				fo.print(scanner.nextInt());
				System.out.println(scanner.nextInt() + " " + i);
//				System.out.println(i);
//				i++;

			}

			// If EOF has been reached
			if (!scanner.hasNext()) {
				System.out.println("End of file.");
				break;
			}

		}

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
