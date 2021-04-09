package lessons;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = { "a", "b", "c" };
		int[] intArr = { 1, 2, 3 };

		// streams only work with reference types. they do not mutate or modify the
		// original data structure directly.
		Stream.of(strArr).forEach(System.out::println);
		Stream.of(strArr).forEach(System.out::println);

		IntStream.of(intArr).forEach(System.out::println);
		Arrays.stream(strArr).forEach(System.out::println);
		Arrays.stream(intArr).forEach(System.out::println);
	}

}
