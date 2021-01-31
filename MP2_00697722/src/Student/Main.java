package Student;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Student> eastQuadCrew2004 = new ArrayList<>();

		eastQuadCrew2004.add(new Student("Becky", 3.9));
		eastQuadCrew2004.add(new Student("Serena", 3.8));
		eastQuadCrew2004.add(new Student("Celia", 3.9));
		eastQuadCrew2004.add(new Student("Steve", 3.8));
		eastQuadCrew2004.add(new Student("Irina", 3.9));
		eastQuadCrew2004.add(new Student("Paul", 3.8));
		eastQuadCrew2004.add(new Student("William", 3.9));

		for (Student s : eastQuadCrew2004) {
			System.out.println(s.toString());
		}

		// *implement generic static method on MySelectionSort class
		// *use MySelectionSort._do() method on UID even though AtomicSort already
		// increments the UID.
		// *Test your class by creating an array of sample students and sort them using
		// the sort method you defined from the last step
		// *Comment out the compareTo method, re-write it to use student’s name to
		// compare instead
	}

}
