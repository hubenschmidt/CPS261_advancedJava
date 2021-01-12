package exceptionHandling;

public class customException {
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
