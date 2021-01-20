package ReadingWithExceptions;

import java.io.File;
import java.io.FileNotFoundException;
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

	public void process(File file) {
		System.out.println(file);
//		try {
//			if (searchFile(file)) {
//				
//			}
//		}
	}

	private void searchFile(File file) throws FileNotFoundException {
		boolean found = false;
		Scanner scanner = new Scanner(file, "UTF-8");

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

}
