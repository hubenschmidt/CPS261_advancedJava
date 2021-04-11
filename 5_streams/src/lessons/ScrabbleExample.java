package lessons;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ScrabbleExample {

	public static int scrapleVal(String word) {
		Map<Character, Integer> letterValues = new HashMap<>();

		letterValues.put('a', 1);
		letterValues.put('b', 3);
		letterValues.put('c', 3);
		letterValues.put('d', 2);
		letterValues.put('e', 1);
		letterValues.put('f', 4);
		letterValues.put('g', 2);
		letterValues.put('h', 4);
		letterValues.put('i', 1);
		letterValues.put('j', 8);
		letterValues.put('k', 5);
		letterValues.put('l', 1);
		letterValues.put('m', 3);
		letterValues.put('n', 1);
		letterValues.put('o', 1);
		letterValues.put('p', 3);
		letterValues.put('q', 10);
		letterValues.put('r', 1);
		letterValues.put('s', 1);
		letterValues.put('t', 1);
		letterValues.put('u', 1);
		letterValues.put('v', 8);
		letterValues.put('w', 4);
		letterValues.put('x', 8);
		letterValues.put('y', 4);
		letterValues.put('z', 10);

		System.out.println(word);

		return word.toLowerCase().chars().map(e -> letterValues.get((char) e)).sum();
	}

	public static void main(String[] args) {

		String[] words = { "Java", "program", "list", "string", "unix",
		        "hours", "syntax", "error" };

		// top three words
//		System.out.println("Top three words are: ");
//		Stream.of(words).sorted((e1, e2) -> scrapleVal(e2) - scrapleVal(e1)).limit(3)
//		        .forEach(e -> System.out.println(e + " : " + scrapleVal(e)));
		// average word value
		System.out.println("\nAverage value fo words is: ");
		double averageScrapleValue = Stream.of(words)
		        .mapToInt(ScrabbleExample::scrapleVal).average().orElse(0.0);
//		System.out.println(averageScrapleValue);
//		// above average words
//		Stream.of(words).collect(Collectors
//		        .partitioningBy((ScrabbleExample::scrapleVal) > averageScrapleValue))
//		        .forEach(e -> System.out.println(e + " : " + scrapleVal(e)));
//		// below average words
//		Stream.of(words).collect(Collectors
//		        .partitioningBy((ScrabbleExample::scrapleVal) < averageScrapleValue))
//		        .forEach(e -> System.out.println(e + " : " + scrapleVal(e)));
	}
}