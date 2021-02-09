package Student;

import java.util.concurrent.atomic.AtomicInteger;

public class Student implements Comparable<Student> {
	private static AtomicInteger uID = new AtomicInteger();
	private int studentId;
	private String lastName;
	private String firstName;
	private double gpa;

	public Student() {
	}

	public Student(String lastName, String firstName, double gpa) {
		super();
		setUID();
		this.lastName = lastName;
		this.firstName = firstName;
		this.gpa = gpa;
	}

	/**
	 * (accessors)getters and (mutators)setters
	 * 
	 */
	public void setUID() {
		this.studentId = uID.incrementAndGet();
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", Last name=" + lastName + ", First name=" + firstName + ", gpa="
				+ gpa + "]";
	}

//	@Override
////	compareTo() method, ordering by student Id.	
//	public int compareTo(Student that) {
//		if (this.getStudentId() > that.getStudentId()) {
//			return 1;
//		} else if (this.getStudentId() < that.getStudentId()) {
//			return -1;
//		}
//		return 0;
//	}

	@Override
//	compareTo() method, ordering by Last Name THEN First Name, or by studentId if alternate method is uncommented.

	public int compareTo(Student that) {
		int last = this.getLastName().compareTo(that.getLastName());
		return last == 0 ? this.getFirstName().compareTo(that.getFirstName()) : last;
	}
}
