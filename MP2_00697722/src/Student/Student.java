package Student;

public class Student implements Comparable {
	private int studentID = 1;
	private String name;
	private double gpa;

	public Student(int studentID, String name, double gpa) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.gpa = gpa;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public int compareTo(Object o) {
		return getStudentID() - this.getStudentID();
	}

}
