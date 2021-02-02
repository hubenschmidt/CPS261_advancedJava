package Student;

import java.util.ArrayList;

//refactor as generic method
public class MySelectionSort {
//	public static <E extends Comparable<E>> void selectionSort(E[] list) {
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			// find position of smallest num between (i+1)th element and last element
			int smallest = i;

			for (int j = i; j < list.size(); j++) {

				if (list.get(smallest).compareTo((list.get(j))) > 0) {
					i = j;
				}

				// swap min (smallest num) to current position on array
				E min = list.get(smallest);
				list.set(smallest, list.get(i));
				list.set(i, min);
				printArray(i + 1, list);

			}

			// swap min (smallest num) to current position on array

		}

//		for (int i = 0; i < list.length - 1; i++) {
//			int iSmallest = i;
//
//			for (int j = i + 1; j < list.length; j++) {
//				if (list[iSmallest].compareTo((list[j])) > 0) {
//					iSmallest = j;
//				}
//			}
//			E iSwap = list[iSmallest];
//			list[iSmallest] = list[i];
//			list[i] = iSwap;
//
//		}
	}

	private static <E> void printArray(int i, ArrayList<E> list) {
		// TODO Auto-generated method stub
		System.out.println(i + " " + list.get(i));

	}

//	public static <E> void printArray(E[] list) {
//
//		for (int i = 0; i < list.length; i++) {
//			System.out.print(list[i] + ", ");
//		}
//	}

}
