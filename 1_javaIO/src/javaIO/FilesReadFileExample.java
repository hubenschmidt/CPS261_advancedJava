package javaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesReadFileExample {

	public static void main(String[] args) {
		Path path = Paths.get("baseball.txt");

		try {
			byte[] bs = Files.readAllBytes(path);
			List<String> strings = Files.readAllLines(path); // angle brackets are generic type. Sometimes used as
																// Type<T>
			System.out.println("Read bytes: \n" + new String(bs));
			System.out.println("Read lines: \n" + strings);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
