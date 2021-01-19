package javaIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Name implements Serializable {
	String first;
	String last;

	public Name(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}

	@Override
	public String toString() {
		return "Name [first=" + first + ", last=" + last + "]";
	}

}

class Student implements Serializable {
	Name name;
	String grade;

	public Student(Name name, String grade) {
		super();
		this.name = name;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + "]";
	}

}

public class ObjIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Student stdn1 = new Student(new Name("Jing", "Bai"), "A");
		Student stdn2 = new Student(new Name("John", "Smith"), "B");
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		Student stdn1FromOis;
		Student stdn2FromOis;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("objOut.dat"));
			oos.writeObject(stdn1);
			oos.writeObject(stdn2);
			ois = new ObjectInputStream(new FileInputStream("objOut.dat"));
			boolean eof = false;
			while (!eof) {

				try {
					System.out.println((Student) ois.readObject());
				} // casting to a student object
				catch (EOFException e) {
					eof = true;
				}
			}

//			stdn1FromOis = (Student) ois.readObject(); // must be cast into a Student type
//			System.out.println(stdn1FromOis);

		} catch (IOException | ClassNotFoundException e) { // another format for exceptions using pipe
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			oos.close();
		}

	}

}
