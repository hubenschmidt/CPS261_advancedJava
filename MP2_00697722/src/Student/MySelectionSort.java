package Student;

//refactor as generic method
public class MySelectionSort {
	public static <T> void sort(T[] arr) {

//		int n = arr.length;
//		System.out.println("arr");

		for (T x : arr) {
			System.out.print(x + ", ");
		}
		System.out.println();

	}

////	public static <T> void sort(int arr[]) {
//	public static <T> sort(T arr) {
//		int n = arr.length;
//		// One by one move boundary of unsorted subarray
//		for (int i = 0; i < n - 1; i++) {
//			// Find the minimum element in unsorted array
//			int min_idx = i;
//			for (int j = i + 1; j < n; j++)
//				if (arr[j] < arr[min_idx])
//					min_idx = j;
//			// Swap the found minimum element with the first
//			// element
//			int temp = arr[min_idx];
//			arr[min_idx] = arr[i];
//			arr[i] = temp;
//		}
//
//		return arr;
//	}

}
