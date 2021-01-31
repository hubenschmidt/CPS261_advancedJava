package Student;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Student> eastQuadCrew2004 = new ArrayList<>();

		eastQuadCrew2004.add(new Student(0, "Becky", 3.9));
		eastQuadCrew2004.add(new Student(0, "Serena", 3.8));
		eastQuadCrew2004.add(new Student(0, "Celia", 3.9));
		eastQuadCrew2004.add(new Student(0, "Steve", 3.8));
		eastQuadCrew2004.add(new Student(0, "Irina", 3.9));
		eastQuadCrew2004.add(new Student(0, "Paul", 3.8));
		eastQuadCrew2004.add(new Student(0, "William", 3.9));

		System.out.println("eastQuadCrew2004: " + eastQuadCrew2004);
	}

}
