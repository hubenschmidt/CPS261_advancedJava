package functionalInterfaceDemo;

interface MyFunctionalInterface {
	public void doSomething(String str1, String str2); // for functional interface, you can only define one abstract
														// method
}

class ConcatStr implements MyFunctionalInterface {
	public void doSomething(String str1, String str2) {
		System.out.println(str1 + str2);
	}
}

class AddLenStr implements MyFunctionalInterface {
	public void doSomething(String str1, String str2) {
		System.out.println(str1.length() + str2.length());
	}
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		String str1 = "Hi";
		String str2 = "Hello";
//		ConcatStr concatStr = new ConcatStr();
//		concatStr.doSomething(str1, str2);
//		AddLenStr addLenStr = new AddLenStr();
//		addLenStr.doSomething(str1, str2);

//		MyFunctionalInterface concatStr = new MyFunctionalInterface() { // this is an "anonymous class"
//			public void doSomething(String str1, String str2) {
//				System.out.println(str1 + str2);
//			}
//		};
//		concatStr.doSomething(str1, str2); // anonymous class implementation;

		// lambda functions:
		MyFunctionalInterface concatStr = (s1, s2) -> {
			System.out.println(s1 + s2);
		};

		MyFunctionalInterface addLenStr = (s1, s2) -> {
			System.out.println(s1.length() + s2.length());
		};

		addLenStr.doSomething(str1, str2);

	}

}
