package lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] myArr = { "aa", "bb", "cc", "dd", "ee" }; // having a string or character twice in this array would
															// result in a runtime error as a result of the Collectors
															// interface

		ArrayList<String> myList = Stream.of(myArr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(myList);

		List<String> list = Stream.of(myArr).collect(Collectors.toList()); // does parallel processing?
		System.out.println(list);

		Map<String, Integer> myMap = Stream.of(myArr).collect(Collectors.toMap(e -> e, e -> e.length()));
		System.out.println(myMap);

	}

}
