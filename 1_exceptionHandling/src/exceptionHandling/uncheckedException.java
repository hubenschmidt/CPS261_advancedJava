package exceptionHandling;

/**
 * 
 * Java also provides UncheckedExceptions, the occurrences of which are not
 * checked by the compiler. They will come into life/occur into your program,
 * once any buggy code is executed.
 * 
 * Most of the times these exception occurs due to the bad data provided by user
 * during the user-program interaction. It is up to the programmer to judge the
 * conditions in advance, that can cause such exceptions and handle them
 * appropriately. All Unchecked exceptions are direct sub classes of
 * RuntimeException class.
 * 
 * Remember the biggest difference between checked and unchecked exceptions is
 * that checked exceptions are forced by compiler and used to indicate
 * exceptional conditions that are out of the control of the program (for
 * example, I/O errors), while unchecked exceptions are occurred during runtime
 * and used to indicate programming errors (for example, a null pointer).
 *
 */

public class uncheckedException {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 0;
		/*
		 * Since I'm dividing an integer with 0 it should throw ArithmeticException
		 */
		int res = num1 / num2;
		System.out.println(res);
	}

}
