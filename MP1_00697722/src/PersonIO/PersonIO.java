package PersonIO;

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
		return getName() + " " + getAge();
	}
}

public class PersonIO {
	String fileName;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	FileInputStream fis = null;
	static Scanner kbInput = new Scanner(System.in);
	List<Object> peopleList = new ArrayList<>();

	public PersonIO(String fileName) {
		this.fileName = fileName;
	}

	public static void initializeBinaryFile(String filePath, PersonIO mp1) throws IOException {
		File file = new File(filePath);

		if (file.isFile()) {
			System.out.println("File exists.");
		} else {
			System.out.println("File doesn't exist or program doesn't have access to the file");
			// initialize Path object
			Path path = Paths.get("person.ser");
			// create file
			try {
				Path createdFilePath = Files.createFile(path);
				System.out.println("File Created at Path: : " + createdFilePath);
				System.out.println(createdFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
		// this will contain the list of the objects
		for (Object l : input) {
			checkList.add(l.getClass().getSimpleName());
			if (l instanceof Person) {
				Person p = (Person) l;
				System.out.println(p.toString());
			}
		}
		ois.close();
	}

	public void add(Person p) throws IOException {
		peopleList.add(p);
		writeToFile(peopleList);
		System.out.println("Added " + p.toString());
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String filePath = "person.ser";
		PersonIO mp1 = new PersonIO(filePath);
		initializeBinaryFile(filePath, mp1);

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
				break;
			default:
				System.out.println(option + " is not a valid entry");
			}

		} while (option != 0);
	}
}