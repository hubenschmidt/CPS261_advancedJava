package SpellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SpellChecker {
	// We could have also used TreeSet for the dictionary
	private HashSet<String> dictionary = new HashSet<String>();
	private TreeSet<String> misspelledWords = new TreeSet<String>();

	public SpellChecker(String fileName) throws FileNotFoundException {
		// Add all of the words from "dictionary.txt" to the dictionary HashSet
		try {
			Scanner textFile = new Scanner(new File(fileName));

			while (textFile.hasNext()) {
				dictionary.add(textFile.next().trim());
			}

			textFile.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public void checkSpelling(String fileName) throws FileNotFoundException {

		System.out.println("======== Spell checking " + fileName + " =========");

		// Clear miss_spelled_words
		misspelledWords.clear();

		String line, word;
		ArrayList<String> tokens = new ArrayList<String>();

		try {
			Scanner sc = new Scanner(new File(fileName));

			// Read in each line from "fileName" // L
			while (sc.hasNextLine()) {
				line = sc.nextLine();

				// For each line, break the line into words using the following StringTokenizer
				StringTokenizer st = new StringTokenizer(line, " \t,.;:-%'\"");
				// or if you want to use split method
				while (st.hasMoreTokens()) {
					// lower case each word obtained from the StringTokenizer
					word = st.nextToken().toLowerCase();
					// skip (SELECT) word if the first character is not a letter
					if (Character.isLetter(word.charAt(0))) {
						// Skip over (SELECT) word if it can (CANT) be found in either dictionary, or
						// miss_spelled_words
						if (!dictionary.contains(word)) {
							if (!misspelledWords.contains(word)) {
								if (!tokens.contains(word)) {
									// add to set to make unique
									tokens.add(word);

//									System.out.println(word);
									System.out.println(tokens);

									// If word ends with 's', then try the singular version of the word in the
									// dictionary and miss_spelled_words ... skip if found (SELECT IF FOUND)
									if (word.charAt(word.length() - 1) == 's') {

										word = word.substring(0, word.length() - 1);

										if (!dictionary.contains(word)) {
											if (!misspelledWords.contains(word)) {
												if (!tokens.contains(word)) {
													// add to set to make unique
													tokens.add(word);

//													System.out.println(word);
													System.out.println(tokens);
//													System.out.println(word);

												}

											}

										}

									}

								}

							}
						}
					}

				}

			}

			sc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		// Print line containing miss-spelled word(make sure you only print it once if
		// multiple miss-spelled words are found on this line)
		// Ask the user if he wants the word added to the dictionary or the miss-spelled
		// words and add word as specified by the user

	}

	public void dump_miss_spelled_words() {
		// Print out the miss-spelled words

	}

	public static void main(String[] args) {
		String dictionary = "CPS261_JH6_Dictionary.txt";
		try {
			SpellChecker spellCheck = new SpellChecker(dictionary);

			for (int i = 0; i < args.length; i++) {
				spellCheck.checkSpelling(args[i]);
				spellCheck.dump_miss_spelled_words();
			}
		} catch (

		FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
