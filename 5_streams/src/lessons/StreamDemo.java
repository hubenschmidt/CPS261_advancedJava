package lessons;

import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = { "James", "Jenna", "Harry", "Robert", "Joe", "Amaury", "Joe" };

		// create stream from source, using of() method
		// limit() is intermediate method
		//
		Stream.of(names).limit(names.length).forEach(e -> System.out.println(e));

		// alternatively, use method reference ::
//		Stream.of(names).limit(5).forEach(System.out::println);

		// skip four names and display the rest sorted ignoring case
		Stream.of(names).skip(names.length - 4).sorted((e1, e2) -> e1.compareToIgnoreCase(e2))
				.forEach(System.out::println);
//		Stream.of(names).skip(2).sorted(String::compareToIgnoreCase).forEach(System.out::println);

		// largest string with length < 4
		System.out.println(Stream.of(names).filter(e -> e.length() < 4).max(String::compareTo).get());

		// smallest string alphabetically
		System.out.println("Smallest string alphabetically: " + Stream.of(names).min(String::compareTo).get());

		// "James" is in names?
		System.out.println("James is in names?");
		System.out.println(Stream.of(names).anyMatch(e -> e.equals("James")));

		// all names start with a capital letter?
		System.out.println("All names start with a capital letter?");
		Stream.of(names).allMatch(e -> Character.isUpperCase(e.charAt(0)));

		// No name begins with Ko?
		System.out.println("No  name begins with Ko? " + Stream.of(names).noneMatch(e -> e.startsWith("Ko")));

		// No name begins with Am?
		System.out.println("No  name begins with Am? " + Stream.of(names).noneMatch(e -> e.startsWith("Am")));

		// Number of distinct case-insensitive strings
		System.out.println("Number of distinct case-insensitive strings: "
				+ Stream.of(names).map(e -> e.toLowerCase()).distinct().count()); // map transforms every element in the
																					// array to lower case strings.
																					// distinct() intermediate method
																					// filters out duplicates
		// first element in this stream is lowercase
		System.out.println("first element in this stream is lower case: ");
		System.out.println(Stream.of(names).map(e -> e.toLowerCase()).findFirst().get());

		// Skip 4 and get any element in this stream
		System.out.println("Skip 4 and get any element in this stream: ");
		System.out.println(Stream.of(names).skip(4).findAny().get()); // findAny is more efficient than find first

	}

}
