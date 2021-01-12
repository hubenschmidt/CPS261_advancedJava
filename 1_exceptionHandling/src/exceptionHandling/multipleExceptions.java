package exceptionHandling;

/**
 * As already mentioned, a try block can contain a code that raises more than
 * one exception. In this case, we will need more than one catch block to handle
 * each exception. A single try block can be followed by multiple catch blocks.
 * Each catch block will handle the independent exceptions.
 * 
 */

public class multipleExceptions {
	public static void main(String[] args) {
		// try block containing exception prone code
		try {
			System.out.println("try Block:: Begin");
			int myArray[] = new int[5];
			myArray[5] = 10 / 0;
		}
		// multiple catch blocks
		catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception :: Divide by zero!!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds :: Accessed index out of bounds");
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		}
		System.out.println("rest of the code");
	}
}
