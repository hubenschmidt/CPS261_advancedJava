package lessons;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArr = { 1, 2, 3 };

		System.out.println(IntStream.of(myArr).reduce((e1, e2) -> e1 * e2).getAsInt());

		String[] names = { "John", "Peter", "Jason", "William", "Joseph", "Mary", "Jen", "Lisa" };

		System.out.println(Stream.of(names).reduce((e1, e2) -> e1 + "," + e2).get());

		// type mismatches when reducing can be solved
		// by mapping first
		System.out.println(IntStream.of(myArr).mapToObj(e -> e + "").reduce((e1, e2) -> e1 + "," + e2).get());

	}
}
