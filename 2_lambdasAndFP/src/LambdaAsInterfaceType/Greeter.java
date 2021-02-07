package LambdaAsInterfaceType;

public class Greeter {

	public void greet(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();

//		Greeting myLambdaFunction = () -> System.out.println("Hello world");
//		MyLambda myLambdaFunction = () -> System.out.print("Hello world");

		/*
		 * This is how you execute lambda expressions: by calling the interface method
		 * on it, just as if it were an instance of a class.
		 * 
		 */
		Greeting lambdaGreeting = () -> System.out.print("Hello world!");

		lambdaGreeting.perform();

		/*
		 * Lambda expressions are syntatic sugar more or less for an inner class, with
		 * some differences. Below is an inline immpleentation of an interface .. an
		 * anonymous inner class
		 * 
		 */
		Greeting innerClassGreeting = new Greeting() { // notice how right hand side does not have a name, this names it
														// anonymous
			public void perform() {
				System.out.print("inner class greeting");
			}
		};

		greeter.greet(lambdaGreeting);
		greeter.greet(innerClassGreeting);

	}
}

//interface MyLambda {
//	void foo();
//}
