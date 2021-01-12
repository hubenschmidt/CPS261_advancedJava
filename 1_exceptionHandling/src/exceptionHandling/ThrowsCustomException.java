package exceptionHandling;

/**
 * The declaration of exception using the “throws” keyword tells the programmer
 * that there may be an exception specified after the “throws” keyword and the
 * programmer should provide corresponding handler code for this exception to
 * maintain the normal flow of the program.
 * 
 * However, the question arises as to why we need a “throws” keyword when we
 * have a more reliable try-catch block to declare and handle exceptions?
 * 
 * One reason is as the number of exceptions that might possibly occur
 * increases, the number of catch block that handles exceptions also increases
 * as one catch block can handle only one exception.
 * 
 * Similarly, if there are many methods in a program and each method has
 * numerous exceptions then the code will become unnecessarily long and
 * unmanageable.
 * 
 * Thus declaring an exception with throws keyword in the method signature and
 * then handling the method call using try-catch seems to be a viable solution.
 * 
 * @author williamroymbp
 *
 */

public class ThrowsCustomException {
	public static void main(String[] args) {
		try {
			doWork(3);
			doWork(2);
			doWork(1);
			doWork(0);
		} catch (NewException e) {
			System.out.println("Exception: " + e.toS());
		}
	}

	static void doWork(int value) throws NewException {
		if (value == 0) {
			throw new NewException();

		} else {
			System.out.println("****No Problem.****");
		}
	}
}
