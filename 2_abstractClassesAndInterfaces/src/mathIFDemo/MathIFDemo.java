package mathIFDemo;

import java.util.Comparator;

//interface MathInterface {
//	public int doSomething(int in1, int int2);
//}

interface MathInterface<T> {
	public T doSomething(T in1, T int2);
}

//public class MathIFDemo {
//	public static int doMath(MathInterface mathIF, int int1, int int2) {
//		return mathIF.doSomething(int1, int2);
//	}

public class MathIFDemo {
	public static <T> T doMath(MathInterface<T> mathIF, T int1, T int2) {
		return mathIF.doSomething(int1, int2);
	}

//	public static int doMathNew(BinaryOperator<Integer> mathIF, int int1, int int2) {
//		return mathIF.apply(int1, int2);
//	}
//
	public static int compareMath(Comparator<Integer> mathIF, int int1, int int2) {
		return mathIF.compare(int1, int2);
	}

	public static void main(String[] args) {
		int int1 = 5;
		int int2 = 6;

		int comparesMath = compareMath((i1, i2) -> i1 - i2, int1, int2);

		int doesMath = doMath((i1, i2) -> i1 + i2, int1, int2); // store the doMath return result in a variable
		System.out.println(doesMath);

		doesMath = doMath((i1, i2) -> i1 - i2, int1, int2);
		System.out.println(doesMath);

		doesMath = doMath((i1, i2) -> i1 * i2, int1, int2);
		System.out.println(doesMath);

		doesMath = doMath((i1, i2) -> i1 / i2, int1, int2);
		System.out.println(doesMath);

	}

}
