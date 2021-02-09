package typeInferenceWithLambdas;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLengthLambda myLambda = (s) -> s.length(); // type inference in the lambda parameter
		StringLengthLambda anotherLambda = s -> s.length(); // type inference in the lambda parameter
		System.out.print(myLambda.getLength("Hello Lambda"));
		System.out.print(myLambda.getLength("Hello anotherLambda"));
		printLambda(s -> s.length());
	}

	public static void printLambda(StringLengthLambda l) {
		System.out.print(l.getLength("Hello printLambda"));
	}

	interface StringLengthLambda {
		int getLength(String s); // type String is inferred in lambda myLambda above
	}

}
