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
	}

}
