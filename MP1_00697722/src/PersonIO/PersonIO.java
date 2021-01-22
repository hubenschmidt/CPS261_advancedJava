package PersonIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Person implements Serializable {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class PersonIO {
	private String fileName;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private static Scanner kbInput = new Scanner(System.in);

	public PersonIO(String fileName) throws FileNotFoundException, IOException {
		this.fileName = fileName;
		this.ois = new ObjectInputStream(new FileInputStream(this.fileName));
		this.oos = new ObjectOutputStream(new FileOutputStream(this.fileName));
	}

	public void add(Person p) throws IOException {
		oos.writeObject(p);
		System.out.println("Added " + p.getName() + ".");
	}

	public void display() throws ClassNotFoundException, IOException, EOFException {

		Person personRead = (Person) ois.readObject();
		System.out.println(personRead);

	}

	public static void main(String[] args) {
		try {
			PersonIO mp1 = new PersonIO("person.ser");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			int option = -1;
			while (option != 0) {
				System.out.println("Please choose an option:");
				System.out.println("0: quit");
				System.out.println("1: add");
				System.out.println("2: display");
				option = kbInput.nextInt();
				kbInput.nextLine();
				switch (option) {
				case 0:
					System.out.println("Bye");
					break;
				case 1:
					// invoke add
					System.out.println("Enter a person's name");
				case 2:
					// invoke display
				}

			}
		} finally {
			// close oos
			// close ois
		}

	}

}
