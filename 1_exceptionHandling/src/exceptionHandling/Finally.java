package exceptionHandling;

/**
 * So far we have seen the try-catch and nested try block. We know that the code
 * that is expected to raise the exception is put in a try block. When an
 * exception occurs, then the remainder of the code in the try block is not
 * executed.
 * 
 * Either the program terminates abruptly if an exception is not handled or the
 * control is passed to the exception handler.
 * 
 * In such a situation, there arises a need to include a code that is to be
 * executed irrespective of whether an exception occurs or not. This means we
 * will execute a piece of code even when an exception occurs and also when the
 * exception does not occur.
 * 
 * @author williamroymbp
 *
 */

class Finally {
	public static void main(String args[]) {
		// try block
		try {
			System.out.println("::Try Block::");
			int data = 125 / 5;
			System.out.println("Result:" + data);
		}
		// catch block
		catch (NullPointerException e) {
			System.out.println("::Catch Block::");
			System.out.println(e);
		}
		// finally block
		finally {
			System.out.println(":: Finally Block::");
			System.out.println("No Exception::finally block executed");
		}
		System.out.println("rest of the code...");
	}
}
