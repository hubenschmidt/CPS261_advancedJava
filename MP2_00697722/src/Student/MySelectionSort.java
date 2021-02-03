package Student;

import java.util.ArrayList;

public class MySelectionSort {
	public static <E extends Comparable<E>> void doSelectionSort(ArrayList<E> arr) {
		for (int i = 0; i < arr.size(); i++) {
			// find position of smallest num between (i + 1)th element and last element
			int pos = i;
			for (int j = i; j < arr.size(); j++) {
				if (arr.get(pos).compareTo((arr.get(j))) > 0)
					pos = j;
			}
			// Swap min (smallest num) to current position on array
			E min = arr.get(pos);
			arr.set(pos, arr.get(i));
			arr.set(i, min);
		}
		printArray(arr);
	}

	private static <E> void printArray(ArrayList<E> list) {
		for (int j = 0; j < list.size(); j++) {
			System.out.println(j + " " + list.get(j));
		}
	}
}
