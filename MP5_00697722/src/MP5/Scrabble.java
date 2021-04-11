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
		return "Scrabble score [word =" + word + ", score=" + score + "]";
	}
}

public class Scrabble {
	static Map<Character, Integer> letterValues = new HashMap();
	static String[] words = { "Java", "program", "list", "string", "unix", "hours", "syntax", "error" };

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

	public static int getScrabbleScore(String word) {
		return word
		        .toLowerCase()
		        .chars() // returns an instance of IntStream
		        .map(e -> letterValues.get((char) e)) // cast IntStream object to char, use as key to get value
		        .sum(); // summarize result
	}

	public static List<ScrabbleWord> getTopThreeWords() {
		return Arrays.stream(words) // compare sequence elements by scrabbleScore
		        .sorted((e1, e2) -> getScrabbleScore(e2) - getScrabbleScore(e1))
		        .limit(3) // based on matching criteria,
		        .map(e -> new ScrabbleWord(e, getScrabbleScore(e))) // create new instance of scrabbleWord object.
		        .collect(Collectors.toList()); // seems to invoke toString() @Override on ScrabbleWord
	}

	public static double getAverageScrabbleWordValue() {
		System.out.println("\nAverage value of Scrabble words is: ");
		double average = Stream.of(words)
		        .mapToInt(e -> getScrabbleScore(e)).average().orElse(0.0);
		return average;

	}

	public static void main(String[] args) {

		// initializes game
		setLetterValues();

		/*
		 * Note to self: using functional programming with object oriented programming
		 * to interact with a database. Since the lambda function returns objects,
		 * instead of printing at terminal operation using forEach(e->sysout), could
		 * also persist ScrabbleWord objects to db.
		 */
		getTopThreeWords().forEach(System.out::println);

		System.out.println(getAverageScrabbleWordValue());

	}

}
