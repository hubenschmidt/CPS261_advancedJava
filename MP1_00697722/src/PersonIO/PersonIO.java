package PersonIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return getName() + " " + getAge();
	}
}

public class PersonIO {
	String fileName;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	static Scanner kbInput = new Scanner(System.in);

	public PersonIO(String fileName) {
		this.fileName = fileName;
//		ois = new ObjectInputStream(new FileInputStream(this.fileName));
//		oos = new ObjectOutputStream(new FileOutputStream(this.fileName, true));
	}

	public void writeToFile(List<Object> person) throws IOException {
		oos = new ObjectOutputStream(new FileOutputStream(this.fileName));
		oos.writeObject(person);
		oos.close();
	}

	public void readFile() throws ClassNotFoundException, IOException {
		ois = new ObjectInputStream(new FileInputStream(this.fileName));

		List<Object> input = (List<Object>) ois.readObject();
		List<Object> checkList = new ArrayList<>();

//		for (int i = 0; i < checkList.size(); i++) {
//			System.out.println(checkList.get(i));
//		}

		// this will contain the list of objects
		for (Object l : input) {
			checkList.add(l.getClass().getSimpleName());

			if (l instanceof Person) {
				Person p = (Person) l;
				System.out.println(p.name);
				System.out.println(p.age);
			}

		}
//		System.out.println(checkList);
		ois.close();
	}

	public void add(Person p) throws IOException {
		// built list of persons before writing to file
		List<Object> peopleList = new ArrayList<>();
		peopleList.add(p);
		writeToFile(peopleList);
		System.out.println("Added " + p.toString());
	}

//	public void display() {
//		try {
//			Person p = (Person) ois.readObject();
//			System.out.println(p.toString());
//		} catch (EOFException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		PersonIO mp1 = new PersonIO("person.ser");
//		try {
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
				System.out.println("Enter age: ");
				int age = kbInput.nextInt();
				Person p = new Person(name, age);
				mp1.add(p);
				break;
			case 2:
				mp1.readFile();
//					mp1.display();
				break;
			default:
				System.out.println(option + " is not a valid entry");
			}

		} while (option != 0);
	}
}
//	}
//}