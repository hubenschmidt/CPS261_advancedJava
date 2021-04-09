package lessons;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Stream case study:
public class WordCount {

	public static void main(String[] args) {
		String str = "one two three one four four five six";

		// gives a count of the words
		Stream.of(str.split(" ")).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		// gives a count of the characters, but has white space
//		Stream.of(str.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
//				.forEach((k, v) -> System.out.println(k + ":" + v));

		// gives a count of the characters, but removes white space with the filter
		// intermediate method
		Stream.of(str.split("")).filter(e -> !e.equals(" "))
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		int[][] intArr = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 6 }, { 5 } };
//		
		Stream.of(intArr).flatMapToInt(e -> IntStream.of(e)).forEach(System.out::println);

	}

}
