package Student;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			// Creating object of ArrayList<Student>
			ArrayList<Student> arrlist = new ArrayList<>();

			// adding element to arrlist
			arrlist.add(new Student("Becky", 3.9));
			arrlist.add(new Student("Serena", 3.8));
			arrlist.add(new Student("Celia", 3.9));
			arrlist.add(new Student("Steve", 3.8));
			arrlist.add(new Student("Irina", 3.9));
			arrlist.add(new Student("Paul", 3.8));
			arrlist.add(new Student("William", 3.9));

			System.out.println("Testing compareTo() method");
			System.out.println("--------------------------");
			// print arrlist
			for (int i = 0; i < arrlist.size() - 1; i++) {

				if (arrlist.get(i) == null) {
					break;
				} else if (arrlist.get(i + 1).compareTo(arrlist.get(i)) == 1) {
					System.out.println(arrlist.get(i + 1) + " studentId exceeds " + arrlist.get(i));
				}
			}
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
