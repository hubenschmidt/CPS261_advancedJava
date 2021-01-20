package ReadingWithExceptions;

import java.io.File;
import java.io.IOException;
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
//		PrintStream printStream = null;

		try {
			scanner = new Scanner(inputFileName);
			readMixedData(scanner);
			// FileOutputStream fo = new FileOuputStream(outputFileName);

		} catch (Exception e) { // what is approproate exception here?
			System.out.println("error: " + e);

		} finally {
			if (scanner != null)
				scanner.close();
		}

	}

	public void readMixedData(Scanner scanner) throws IOException {
		setOutputFileName(scanner.next());
		System.out.println(getOutputFileName());
//			if (scanner.hasNextInt())

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

}
