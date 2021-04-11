package MP5;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SingleDigits {
	// count frequency each random number 0-9 appears in the stream
	public static void main(String[] args) {
		Stream<Integer> randomNumbers = Stream
		        .generate(() -> (new Random()).nextInt(10));

		randomNumbers
		        .limit(100)
		        .mapToInt(e -> Integer.valueOf(e))
		        .boxed()
		        .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
		        .forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
