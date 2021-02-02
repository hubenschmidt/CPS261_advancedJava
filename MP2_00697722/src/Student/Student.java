package Student;

import java.util.concurrent.atomic.AtomicInteger;

public class Student implements Comparable<Student> {
	private static AtomicInteger uID = new AtomicInteger();
	private int studentId;
	private String name;
	private double gpa;

	// for testing:
	public Student() {
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Student(String name, double gpa) {
		super();
		setUID();
		this.name = name;
		this.gpa = gpa;
	}

	/**
	 * (accessors)getters and (mutators)setters
	 * 
	 */

	public void setUID() {
		this.studentId = uID.incrementAndGet();
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", gpa=" + gpa + "]";
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public int compareTo(Student that) {
		if (this.getStudentId() > that.getStudentId()) {
			return 1;
		} else if (this.getStudentId() < that.getStudentId()) {
			return -1;
		}
		return 0;
	}
}
