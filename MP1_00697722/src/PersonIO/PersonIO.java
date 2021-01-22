package PersonIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Person implements Serializable {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
}

public class PersonIO {
	String fileName;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	static Scanner kbInput = new Scanner(System.in);

	public PersonIO(String fileName) throws FileNotFoundException, IOException {
		this.fileName = fileName;

		oos = new ObjectOutputStream(new FileOutputStream(this.fileName));
		ois = new ObjectInputStream(new FileInputStream(this.fileName));

	}

	public void add(Person p) throws IOException {
		oos.writeObject(p);
		System.out.println("Added " + p.getName() + ".");
	}

	public void display() {
		System.out.println("Invoke display");
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PersonIO mp1 = new PersonIO("person.ser");
		try {
			int option = -1;
			do {
				System.out.println("Please choose an option:");
				System.out.println("0: quit");
				System.out.println("1: add");
				System.out.println("2: display");
				option = kbInput.nextInt();
				kbInput.nextLine();
				System.out.println("You entered: " + option);
				switch (option) {
				case 0:
					System.out.println("Bye.");
					break;
				case 1:
					System.out.println("Enter name: ");
					String name = kbInput.nextLine();
//					System.out.println("Enter age: ");
//					int age = kbInput.nextInt();
					System.out.println("You entered: " + name);
					break;
				case 2:
					mp1.display();
				default:
					System.out.println(option + " is not a valid entry");
				}

			} while (option != 0);
		} finally {
			try {
				// close ois
				if (mp1.ois != null) {
					mp1.ois.close();
				}
				// close oos
				if (mp1.oos != null) {
					mp1.oos.close();
				}

			} catch (IOException e) {
				System.out.println("Error.");
				e.printStackTrace();
			}

		}

	}

	public static void processMenuInput(int in) {
		System.out.print(in);

	}

}