package PersonIO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		return "Name: " + getName() + ", Age: " + getAge();
	}
}

public class PersonIO {
	private String fileName;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private FileInputStream fis = null;
	static Scanner kbInput = new Scanner(System.in);
	List<Object> peopleList = new ArrayList<>();

	public PersonIO(String fileName) {
		this.fileName = fileName;
	}

	public void setPeopleList(List<Object> peopleList) {
		this.peopleList = peopleList;
	}

	public static void initializeBinaryFile(String filePath, PersonIO mp1) throws IOException {
		File file = new File(filePath);
		// check for existence of binary file
		if (file.isFile()) {
			return;
		} else {
			Path path = Paths.get(filePath);
			Path createdFilePath = Files.createFile(path);
		}
	}

	public void preFetchPeopleListFromBinaryFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		try {
			ois = new ObjectInputStream(new FileInputStream(this.fileName));
			List<Object> input = (List<Object>) ois.readObject();
			setPeopleList(input);
		} catch (EOFException e) {
			return;
		}
	}

	public void writeToFile(List<Object> person) throws IOException {
		oos = new ObjectOutputStream(new FileOutputStream(this.fileName));
		oos.writeObject(person);
		oos.close();
	}

	public void readFile() throws ClassNotFoundException, IOException {
		try {
			ois = new ObjectInputStream(new FileInputStream(this.fileName));
			List<Object> input = (List<Object>) ois.readObject();
			List<Object> displayList = new ArrayList<>();

			System.out.println();
			System.out.println("DISPLAYING ENTRIES");
			System.out.println("-------------------");
			for (Object l : input) {
				displayList.add(l.getClass().getSimpleName());
				if (l instanceof Person) {
					Person p = (Person) l;
					System.out.println(p.toString());
				}
			}
			System.out.println();
			ois.close();
		} catch (EOFException e) {
			System.out.println("..but there is nothing to display here.");
			System.out.println();
			return;
		}

	}

	public void add(Person p) throws IOException {
		peopleList.add(p);
		writeToFile(peopleList);
		System.out.println();
		System.out.println("******");
		System.out.println("ADDING " + p.toString());
		System.out.println("******");
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String filePath = "person.ser";
		PersonIO mp1 = new PersonIO(filePath);
		initializeBinaryFile(filePath, mp1);
		mp1.preFetchPeopleListFromBinaryFile();

		int option = -1;
		do {
			System.out.println("Please choose an option:");
			System.out.println("0: quit");
			System.out.println("1: add");
			System.out.println("2: display");
			option = kbInput.nextInt();
			kbInput.nextLine();
			System.out.println();
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
				break;
			default:
				System.out.println(option + " is not a valid entry");
			}

		} while (option != 0);
	}
}