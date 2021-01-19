package javaIO;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesWriteFileExample {

	public static void main(String[] args) {
		Path path = Paths.get("writeFileExample.txt");
		try {
			String str = "This is write file Example";
			byte[] bs = str.getBytes();
			Path writtenFilePath = Files.write(path, bs);
			System.out.println("Written content in file:\n" + new String(Files.readAllBytes(writtenFilePath)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
