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
	ArrayList<String> auditLines = new ArrayList<>();
	HashSet<String> checkWords = new HashSet<String>();

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

	public void promptUser(String word) {

		Scanner kb = new Scanner(System.in);

		char dictionarySelection = 'Y';
		char misSpelledWordsSelection = 'Y';

		if (!checkWords.contains(word)) {
			System.out.println();
			System.out.println(word + " is not in the dictionary. Add to dictionary? (Y/N)");
			dictionarySelection = kb.nextLine().toUpperCase().charAt(0);

			if (dictionarySelection == 'Y') {
				dictionary.add(word);
				checkWords.add(word);

			} else if (dictionarySelection == 'N') {
				System.out.println("Add " + word + " to misspelled words list? (Y/N)");
				misSpelledWordsSelection = kb.nextLine().toUpperCase().charAt(0);

				if (misSpelledWordsSelection == 'Y') {
					misspelledWords.add(word);
					checkWords.add(word);
					System.out.println("     Verified misspelled words list: " + misspelledWords);
				}

			} else {
				System.out.println("Please enter a valid choice.");
			}

			System.out.println("     Number of words in dictionary: " + dictionary.size());
			System.out.println();

		}

	}

	public void checkSpelling(String fileName) throws FileNotFoundException {

		System.out.println("======== Spell checking " + fileName + " =========");

		// Clear misspelledWords
		misspelledWords.clear();

		String line, word;
		boolean sentry = false;

		int counter = 0;

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

								// add to set to make unique
								auditLines.add(word);
								counter++;

								sentry = true;

								// If word ends with 's', then try the singular version of the word in the
								// dictionary and miss_spelled_words ... skip if found (SELECT IF FOUND)
								if (word.charAt(word.length() - 1) == 's') {

									word = word.substring(0, word.length() - 1);

									if (!dictionary.contains(word)) {
										if (!misspelledWords.contains(word)) {

											auditLines.add(word);
											counter++;

											sentry = true;
										}

									}

								}

							}
						}
					}

				}

				// iterate over ArrayList, prompting user per element.
				if (sentry) {
					System.out.println(counter + ": " + line);
					for (String el : auditLines) {
						promptUser(el);

					}
				}
				auditLines.clear();

			}

			// close scanner, print misspelled words list and clear.
			if (!sc.hasNextLine()) {
				sc.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public void dumpMisspelled() {
		// Print out the miss-spelled words
		System.out.println("End of file has been reached.");
		System.out.println("     Verified misspelled words list: " + misspelledWords);
		System.out.println();

	}

	public static void main(String[] args) {
		String dictionary = "CPS261_JH6_Dictionary.txt";
		try {
			SpellChecker spellCheck = new SpellChecker(dictionary);

			for (int i = 0; i < args.length; i++) {
				spellCheck.checkSpelling(args[i]);
				spellCheck.dumpMisspelled();
			}
		} catch (

		FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
