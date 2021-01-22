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

/**
 * 
 * @author williamroymbp
 *
 */

class Person implements Serializable {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Getters
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "NAME: " + getName() + " AGE: " + getAge();
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

	/**
	 * Build an ArrayList of Person objects based on user input.
	 * 
	 * @param p
	 * @throws IOException
	 */
	public void add(Person p) throws IOException {
		peopleList.add(p);
		writeToFile(peopleList);
		System.out.println();
		System.out.println("*****");
		System.out.println("ADDING " + p.toString());
		System.out.println("*****");
		System.out.println();
	}

	/**
	 * Serialize Person objects to binary file.
	 * 
	 * @param person
	 * @throws IOException
	 */
	public void writeToFile(List<Object> person) throws IOException {
		oos = new ObjectOutputStream(new FileOutputStream(this.fileName));
		oos.writeObject(person);
		oos.close();
	}

	/**
	 * Deserialize Person objects from binary file, build an ArrayList of Person
	 * objects, display output in console.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void readFile() throws ClassNotFoundException, IOException {
		ois = new ObjectInputStream(new FileInputStream(this.fileName));
		List<Object> input = (List<Object>) ois.readObject();
		List<Object> displayList = new ArrayList<>();

		for (Object l : input) {
			displayList.add(l);
			Person p = (Person) l;

			System.out.println();
			System.out.println("DISPLAY ALL ENTRIES:");
			System.out.println("---------------------");
			System.out.println(p.toString());
			System.out.println();
			System.out.println();
		}
		ois.close();
	}

	/**
	 * Display menu to generate program input.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		PersonIO mp1 = new PersonIO("person.ser");
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