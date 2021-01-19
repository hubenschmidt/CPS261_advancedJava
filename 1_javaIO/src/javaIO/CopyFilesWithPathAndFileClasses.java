package javaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFilesWithPathAndFileClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Path sourceFile = Paths.get(".", "input.txt");
		Path targetFile = Paths.get("/Users/williamroymbp/WCC/CPS261_advancedJava/1_javaIO", "target2.txt");

		// prints current relative path
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current absolute path is: " + s);

		try {
			Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
