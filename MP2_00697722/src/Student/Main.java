package Student;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		try {
			ArrayList<Student> arrlist = new ArrayList<Student>();

			// add Students using constructor, increment studentId using AtomicInteger
			arrlist.add(new Student("Blose", "Becky", 3.4));
			arrlist.add(new Student("Renda", "Serena", 3.2));
			arrlist.add(new Student("Wolfman", "Celia", 3.9));
			arrlist.add(new Student("Olsen", "Steve", 3.8));
			arrlist.add(new Student("Lyons", "Irina", 2.9));
			arrlist.add(new Student("Czarnecki", "Paul", 3.3));
			arrlist.add(new Student("Hubenschmidt", "Roy", 3.4));
			arrlist.add(new Student("Hubenschmidt", "William", 3.6));
			arrlist.add(new Student("Lynn", "Rob", 3.9));
			arrlist.add(new Student("Lynn", "Erica", 3.9));

			// add Students using setters, manually assign studentId
			Student s1 = new Student();
			s1.setStudentId(13);
			s1.setLastName("Gentle");
			s1.setFirstName("Joe");
			s1.setGpa(3.1);
			arrlist.add(s1);

			Student s2 = new Student();
			s2.setStudentId(12);
			s2.setLastName("Stenvig");
			s2.setFirstName("Jane");
			s2.setGpa(3.8);
			arrlist.add(s2);

			Student s3 = new Student();
			s3.setStudentId(18);
			s3.setLastName("Hammond-Bennett");
			s3.setFirstName("Austin");
			s3.setGpa(2.8);
			arrlist.add(s3);

			Student s4 = new Student();
			s4.setStudentId(24);
			s4.setLastName("Clark");
			s4.setFirstName("Phil");
			s4.setGpa(3.0);
			arrlist.add(s4);

			Student s5 = new Student();
			s5.setStudentId(9);
			s5.setLastName("Welch");
			s5.setFirstName("Molly");
			s5.setGpa(3.1);
			arrlist.add(s5);

			/*
			 * Testing compareTo() method
			 */

			System.out.println();
			System.out.println("Testing compareTo() method");
			System.out.println("--------------------------");

			for (int i = 0; i < arrlist.size() - 1; i++) {
				if (arrlist.get(i) == null) {
					System.out.println("Student array list empty");
					break;
				} else if (arrlist.get(i + 1).compareTo(arrlist.get(i)) > 0) {
					System.out.println(arrlist.get(i + 1) + " IS GREATER THAN " + arrlist.get(i));
				} else if (arrlist.get(i + 1).compareTo(arrlist.get(i)) < 0) {
					System.out.println(arrlist.get(i + 1) + " IS LESS THAN " + arrlist.get(i));
				}
			}

			/*
			 * Testing doSelectionSort() method
			 */
			System.out.println();
			System.out.println("Testing MySelectionSort.selectionSort() generic static method");
			System.out.println("--------------------------");

			MySelectionSort.doSelectionSort(arrlist);
		}

		catch (IndexOutOfBoundsException e) {
			System.out.println("Exception thrown : " + e);
			return;
		}
	}
}
