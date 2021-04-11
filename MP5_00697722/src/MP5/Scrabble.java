package MP5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ScrabbleWord {
	private String word;
	private int score;

	public ScrabbleWord(String word, int score) {
		this.word = word;
		this.score = score;
	}

	public String getWord() {
		return word;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return word + ": " + score;
	}

}

public class Scrabble {
	static Map<Character, Integer> letterValues = new HashMap();
	static String[] words = { "Java", "program", "list", "string", "unix", "hours", "syntax", "error" };
	private double averageScore;

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public static void setLetterValues() {
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

	}

	/*
	 * lambda functions that compute values using stream aggregate operations
	 */
	public static int computeScrabbleScore(String word) {
		return word
		        .toLowerCase()
		        .chars() // returns an instance of IntStream
		        .map(el -> letterValues.get((char) el)) // cast IntStream object to char, use as key to get value
		        .sum(); // summarize result
	}

	public static List<ScrabbleWord> computeWordValue(int threshold) {
		return Arrays.stream(words) // compare sequence elements by scrabbleScore
		        .sorted((el1, el2) -> computeScrabbleScore(el2) - computeScrabbleScore(el1))
		        .limit(threshold) // based on matching criteria,
		        .map(el -> new ScrabbleWord(el, computeScrabbleScore(el))) // create new instance of scrabbleWord
		                                                                   // object.
		        .collect(Collectors.toList()); // seems to invoke toString() @Override on ScrabbleWord
	}

	public static double computeAverageScrabbleWordValue() {
		double average = Stream.of(words)
		        .mapToInt(el -> computeScrabbleScore(el)).average().orElse(0.0);
		return average;

	}

	public static List<ScrabbleWord> computeWordsAboveAverage(Scrabble scrabble) {
		return computeWordValue(words.length)
		        .stream()
		        .filter(el -> el.getScore() > scrabble.getAverageScore())
		        .collect(Collectors.toList());
	}

	public static List<ScrabbleWord> computeWordsBelowAverage(Scrabble scrabble) {

		return computeWordValue(words.length)
		        .stream()
		        .filter(el -> el.getScore() < scrabble.getAverageScore())
		        .collect(Collectors.toList());
	}

	public static void main(String[] args) {
		// initialize game
		Scrabble scrabble = new Scrabble();
		setLetterValues();
		/*
		 * Note to self: using functional programming with object oriented programming
		 * to interact with a database. Since the lambda function returns objects,
		 * instead of printing at terminal operation using forEach(e->sysout), could
		 * also persist ScrabbleWord objects to db.
		 */
		System.out.println("Top three words are: ");
		computeWordValue(3).forEach(System.out::println);
		scrabble.setAverageScore(computeAverageScrabbleWordValue());
		System.out.println("\nAverage scrabble value is: " + scrabble.getAverageScore());
		System.out.println("\nWords below average:");
		System.out.println(computeWordsBelowAverage(scrabble));
		System.out.println("\nWords above average:");
		System.out.println(computeWordsAboveAverage(scrabble));
	}

}
