package SpellChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class SpellChecker {
	// We could have also used TreeSet for the dictionary
	private HashSet<String> dictionary = new HashSet<String>();
	// LinkedHashSet preserves insertion order for processing
	private LinkedHashMap<Integer, String> misspelledWords = new LinkedHashMap<Integer, String>();
	private Set s = misspelledWords.entrySet();
	private ArrayList<String> verifiedMisspelledWords = new ArrayList<String>();

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
							if (!misspelledWords.containsValue(word)) {

								// add to set to make unique
								misspelledWords.put(counter, word);
								counter++;

								// If word ends with 's', then try the singular version of the word in the
								// dictionary and miss_spelled_words ... skip if found (SELECT IF FOUND)
								if (word.charAt(word.length() - 1) == 's') {

									word = word.substring(0, word.length() - 1);

									if (!dictionary.contains(word)) {
										if (!misspelledWords.containsValue(word)) {
											// add to set to make unique
											misspelledWords.put(counter, word);
											counter++;
										}

									}

								}

							}
						}
					}

				}

			}

			// iterating over key-value pairs derived from LinkedHashSet
			Iterator it = s.iterator();

			while (it.hasNext()) {

				Map.Entry<Integer, String> entry = (Entry<Integer, String>) it.next();
				int key = entry.getKey();
				String value = entry.getValue();
				userPrompt(it, key, value);

			}

			// close scanner, print misspelled words list and clear.
			if (!sc.hasNextLine()) {
				sc.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

	}

	public void userPrompt(Iterator<String> itr, int key, String value) {
		Scanner kb = new Scanner(System.in);
		char dictionarySelection = 'Y';
		char misSpelledWordsSelection = 'Y';

		System.out.println();
		System.out.println(value + " is not in the dictionary. Add to dictionary? (Y/N)");
		dictionarySelection = kb.nextLine().toUpperCase().charAt(0);

		if (dictionarySelection == 'Y') {
			dictionary.add(value);

		} else if (dictionarySelection == 'N') {
			System.out.println("Add " + value + " to misspelled words list? (Y/N)");
			misSpelledWordsSelection = kb.nextLine().toUpperCase().charAt(0);

			if (misSpelledWordsSelection == 'Y') {
				verifiedMisspelledWords.add(value);
				System.out.println("     Verified misspelled words list: " + verifiedMisspelledWords);
			}

		} else {
			System.out.println("Please enter a valid choice.");
		}

		System.out.println("     Number of words in dictionary: " + dictionary.size());
		System.out.println();

	}

	public void dumpMisspelled() {
		// Print out the miss-spelled words
		System.out.println("End of file has been reached.");
		System.out.println("     Verified misspelled words list: " + verifiedMisspelledWords);
		verifiedMisspelledWords.clear();

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
