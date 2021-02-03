package Student;

import java.util.ArrayList;

//refactor as generic method
public class MySelectionSort {
	// Create doSelectionSort method
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
			printArray(i + 1, arr);
		}
	}

	public static <E extends Comparable<E>> void selectionSortArray(E[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			int iSmallest = i;

			for (int j = i + 1; j < list.length; j++) {
				if (list[iSmallest].compareTo((list[j])) > 0) {
					iSmallest = j;
				}
			}
			E iSwap = list[iSmallest];
			list[iSmallest] = list[i];
			list[i] = iSwap;

		}
	}

	private static <E> void printArray(int i, ArrayList<E> list) {
		// TODO Auto-generated method stub
		for (int j = 0; j < list.size(); j++) {
			System.out.println(j + " " + list.get(j));

		}

	}

}
