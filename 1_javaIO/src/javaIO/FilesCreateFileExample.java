package javaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Java creat file using Files class
 * 
 * @author williamroymbp
 *
 */

public class FilesCreateFileExample {
	public static void main(String[] args) {
		// initialize Path object
		Path path = Paths.get("somePathCreatedFile.txt");
		// create file
		try {
			Path createdFilePath = Files.createFile(path);
			System.out.println("File Created at Path: : " + createdFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
