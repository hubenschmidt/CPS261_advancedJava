package lessons;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupingByDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = { "John", "Peter", "Susan", "Kim", "George", "Alan", "Stacy", "Steve", "john" };

		// toUpperCase groups the John and john together
		Map<Character, Long> myMap = Stream.of(names)
				.collect(Collectors.groupingBy(e -> e.toUpperCase().charAt(0), TreeMap::new, Collectors.counting()));

		System.out.println(myMap);

		int[] intArr = { 1, 1, 2, 5, 6, 5, 5, 5, 2, 4, 8, 4 };
//		IntStream.of(intArr).boxed().collect(Collectors.groupingBy(e -> e))
//				.forEach((k, v) -> System.out.println(k + ":" + v));
		IntStream.of(intArr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));
	}

}
