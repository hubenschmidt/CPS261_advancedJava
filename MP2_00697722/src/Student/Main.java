package Student;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			// Creating object of ArrayList<Student>
			ArrayList<Student> arrlist = new ArrayList<Student>();

			// adding element to arrlist
//			arrlist.add(new Student("Becky", 3.9));
//			arrlist.add(new Student("Serena", 3.8));
//			arrlist.add(new Student("Celia", 3.9));
//			arrlist.add(new Student("Steve", 3.8));
//			arrlist.add(new Student("Irina", 3.9));
//			arrlist.add(new Student("Paul", 3.8));
//			arrlist.add(new Student("William", 3.9));

			Student s1 = new Student();
			s1.setStudentId(1);
			s1.setName("Becky");
			s1.setGpa(3.9);
			arrlist.add(s1);

			Student s2 = new Student();
			s1.setStudentId(2);
			s1.setName("Serena");
			s1.setGpa(3.8);
			arrlist.add(s2);

			Student s3 = new Student();
			s1.setStudentId(3);
			s1.setName("Celia");
			s1.setGpa(3.8);
			arrlist.add(s3);

//			MySelectionSort.selectionSort(arrlist);

			System.out.println("Testing compareTo() method");
			System.out.println("--------------------------");
			for (int i = 0; i < arrlist.size() - 1; i++) {
				System.out.println("test");

				if (arrlist.get(i) == null) {
					System.out.println("Student array list empty");
					break;
				} else if (arrlist.get(i + 1).compareTo(arrlist.get(i)) == 1) {
					System.out.println(arrlist.get(i + 1) + " studentId exceeds " + arrlist.get(i));
				}
			}
//
//			System.out.println();
//			System.out.println("Testing MySelectionSort.selectionSort() generic static method");
//			System.out.println("--------------------------");

//			Integer[] list = { 34, 17, 23, 35, 45, 9, 1 };
//			System.out.println("Original Array: ");
//			MySelectionSort.printArray(list);
//
//			MySelectionSort.selectionSort(list);
//			System.out.println("\nSelection sort:");
//			MySelectionSort.printArray(list);
//			Float[] flist = { 34.4f, 17.6f, 23.0f };
//			MySelectionSort.selectionSort(list);

		}

		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown : " + e);
			return;
		}

//		for (Student s : eastQuadCrew04) {
//			System.out.println(s.toString());
//		}

		// *implement generic static method on MySelectionSort class
		// *use MySelectionSort._do() method on UID even though AtomicSort already
		// increments the UID.
		// *Test your class by creating an array of sample students and sort them using
		// the sort method you defined from the last step
		// *Comment out the compareTo method, re-write it to use student’s name to
		// compare instead
	}

}
