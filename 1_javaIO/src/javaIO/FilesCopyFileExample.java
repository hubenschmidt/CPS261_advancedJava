package javaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopyFileExample {

	public static void main(String[] args) {
		Path sourcePath = Paths.get("baseball.txt");
		Path targetPath = Paths.get("baseballTargetFile.txt");

		try {
			Path path = Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING); // copy with
																									// REPLACE_EXISTING
																									// option
			System.out.println("Target file Path : " + path);

			System.out.println("Copied Content: \n" + new String(Files.readAllBytes(path)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
