package Student;

import java.util.concurrent.atomic.AtomicInteger;

public class Student implements Comparable {
	private static AtomicInteger uID = new AtomicInteger();
	private int studentID;
	private String name;
	private double gpa;

	public Student(int studentID, String name, double gpa) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.gpa = gpa;
	}

	/**
	 * (accessors)getters and (mutators)setters
	 * 
	 * @param uID
	 */

	public void setUID(AtomicInteger uID) {
		this.uID = uID;
	}

	public int getStudentID() {
		return studentID;
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
