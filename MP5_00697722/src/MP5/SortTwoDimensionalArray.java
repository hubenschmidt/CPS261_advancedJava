package MP5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortTwoDimensionalArray {

	public static void main(String[] args) {
		int[][] intArr = { { 34, 89 }, { 56, 3 }, { 27, 61 }, { 45, 8 }, { 45, 89 } };
		Stream.of(intArr)
		        .flatMapToInt(e -> IntStream.of(e))
		        .distinct()
		        .boxed()
		        .sorted()
//		        .sorted(Comparator.reverseOrder())
		        .forEach(result -> System.out.print(result + " "));

	}

}
