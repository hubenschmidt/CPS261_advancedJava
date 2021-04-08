package lessons;

import java.util.stream.Stream;

class GFG2 {

	// Function convert a List into Stream
	private static void getStream() {

		// Create a stream from specified values
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// Displaying the sequential ordered stream
		stream.forEach(p -> System.out.print(p + " "));
	}

	public static void main(String[] args) {

		// Get the Stream from the values
		getStream();
	}
}
