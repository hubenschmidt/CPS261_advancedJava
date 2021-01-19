package javaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesMoveFileExample {

	public static void main(String[] args) {
		Path sourcePath = Paths.get("sourceFile.txt");
		Path targetPath = Paths.get("targetFile.txt");

		try {
			Path path = Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING); // move with
																									// REPLACE_EXISTING
																									// option
			System.out.println("Target file Path: " + path);
			System.out.println("Moved Content: \n" + new String(Files.readAllBytes(path)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
