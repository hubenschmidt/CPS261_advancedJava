package exceptionHandling;

/**
 * 
 * A try block inside another try block is called a nested try block. We need
 * such structures in certain situations when a piece of code contained in a try
 * code may be such that some lines raise certain exceptions and another piece
 * of code raises a completely different exception.
 * 
 * In case of nested try blocks, first, the innermost try block is executed and
 * the exception is handled. If the innermost try block does not have a matching
 * catch block, then it is propagated one level up to its parent try block. This
 * way the exception is propagated upwards till matching exception handler is
 * found.
 * 
 * If there is no exception handler matching the exception, then the program is
 * abruptly terminated with a system-generated message.
 *
 */

class nestedTryCatch {
	public static void main(String args[]) {
		// Main try block
		try {
			// try block1
			try {
				System.out.println("Try Block1");
				int num = 15 / 0;
				System.out.println(num);
			} catch (ArithmeticException e1) {
				System.out.println("Block1 Exception: e1");
			}
			// try block2
			try {
				System.out.println("Try Block2");
				int num = 100 / 0;
				System.out.println(num);
			} catch (ArrayIndexOutOfBoundsException e2) {
				System.out.println("Block2 Exception: e2");
			}
			System.out.println("General statement after Block1 and Block2");
		} catch (ArithmeticException e3) {
			System.out.println("Main Block Arithmetic Exception");
		} catch (ArrayIndexOutOfBoundsException e4) {
			System.out.println("Main Block ArrayIndexOutOfBoundsException");
		} catch (Exception e5) {
			System.out.println("Main Block General Exception");
		}
		System.out.println("Code after Nested Try Block");
	}
}
