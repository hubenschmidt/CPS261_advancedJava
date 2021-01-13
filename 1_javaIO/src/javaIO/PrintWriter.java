package javaIO;

import java.io.FileWriter;
import java.util.Locale;

/**
 * The Java PrintWriter class (java.io.PrintWriter) enables you to write
 * formatted data to an underlying Writer. For instance, writing int, long and
 * other primitive data formatted as text, rather than as their byte values.
 * 
 * The Java PrintWriter is useful if you are generating reports (or similar)
 * where you have to mix text and numbers. The PrintWriter class has all the
 * same methods as the PrintStream except for the methods to write raw bytes.
 * Being a Writer subclass the PrintWriter is intended to write text.
 * 
 * @author williamroymbp
 *
 */

public class PrintWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter writer = new FileWriter("d:\\data\\report.txt");
		PrintWriter printWriter = new PrintWriter(writer);

		printWriter.print(true);
		printWriter.print((int) 123);
		printWriter.print((float) 123.456);

		printWriter.printf(Locale.UK, "Text + data: %1$", 123);

		printWriter.close();

	}

}
