package javaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesCreateDirectoriesExample {

	public static void main(String[] args) {
		// initialize Path objects
		Path path1 = Paths.get("TestPaths");
		Path path2 = Paths.get("../Paths2inCPS261Folder");
		try {
			Path createdDir1 = Files.createDirectory(path1); // first level directory
			Path createdDir2 = Files.createDirectory(path2); // second level direcvtory

			System.out.println("Second Level Directory Created at Path : " + createdDir1);
			System.out.println("First level Direcotry Created at Path : " + createdDir2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
