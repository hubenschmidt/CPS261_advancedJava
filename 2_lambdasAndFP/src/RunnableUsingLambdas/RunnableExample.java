package RunnableUsingLambdas;

public class RunnableExample {

	public static void main(String[] args) {

		// before java 8, Thread interface would be implemented like so:
		Thread myThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed inside runnable");
			}

		});
		myThread.run();

		// in Java 8, a lambda is essentially indistinguishable from the implementation
		// of Thread interface above, like so:
		// and backwards compatibility exists as long as the interface has only one
		// abstract method
		Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
		myLambdaThread.run();
	}

}
