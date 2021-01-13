package javaIO;

/**
 * The Java FileWriter class, java.io.FileWriter, makes it possible to write
 * characters to a file. In that respect the Java FileWriter works much like the
 * FileOutputStream except that a FileOutputStream is byte based, whereas a
 * FileWriter is character based. The FileWriter is intended to write text, in
 * other words. One character may correspond to one or more bytes, depending on
 * the character encoding scheme in use. The Java FileWriter class is a subclass
 * of the Java Writer class, by the way.
 * 
 * @author williamroymbp
 *
 */

public class FileWriter {

	public static void main(String[] args) {

		Writer fileWriter = new FileWriter("data\\filewriter.txt");

		fileWriter.write("data 1");
		fileWriter.write("data 2");
		fileWriter.write("data 3");

		fileWriter.close();

	}

}
