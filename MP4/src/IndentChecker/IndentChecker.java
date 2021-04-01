package IndentChecker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.Stack;

class BadIndentationException extends RuntimeException {
	BadIndentationException(String error) {
		super(error);
	}
}

public class IndentChecker {
	Stack<Integer> indentStack = new Stack<Integer>();

	private int findFirstNonBlank(String line) {
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			boolean d = Character.isWhitespace(c);
			if (!d) {
				return i;
			}
		}
		return -1;

	}

	private void processLine(String line, int lineNumber) {
		System.out.println("Line " + lineNumber + ": " + line);
		int index = findFirstNonBlank(line);

		// Skip blank lines ... i.e. return immediately
		if (index == -1) {
			return;
		}

//		System.out.println("The stack is: " + indentStack);

		// If the stack is empty, then push this index onto the stack and return
		if (indentStack.empty()) {
			indentStack.push(index);
			return;
		}
// If this index > than the top of the stack, then push this index onto the stack and return
		if (index > indentStack.peek()) {
			indentStack.push(index);
			return;
		}

		// Pop off all Indentation indexes > index
		while (indentStack.peek() > index) {
			indentStack.pop();
		}

		// At his point the top of the stack should match the current index. If it
// doesn't throw a BadIndentationException. In the error message, include the source Line Number
		if (indentStack.peek() != index) {
			throw new BadIndentationException("indentation error found on line " + lineNumber + ".");
		}
	}

	public void checkIndentation(String fileName) throws IOException {
		// Clear the stack
		indentStack.clear();
		Scanner s = null;
		LineNumberReader r = new LineNumberReader(new FileReader(fileName));
		String l;
		try {
			// read through the file line by line
			// for each line, call processLine to check indentation
			while ((l = r.readLine()) != null) {
				s = new Scanner(l);

				while (s.hasNext()) {
//					System.out.println("Line " + r.getLineNumber() + ": " + s.nextLine());
					processLine(s.nextLine(), r.getLineNumber());
				}
			}
		} catch (BadIndentationException error) {
			System.out.println(error);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file:" + fileName);
		} finally {
			if (s != null)
				s.close();
		}
	}

	public static void main(String[] args) throws IOException {

		IndentChecker indentChecker = new IndentChecker();

		for (int i = 0; i < args.length; i++) {
			System.out.println("Processing file: " + args[i]);
			indentChecker.checkIndentation(args[i]);
		}
	}
}