package javaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultiObjectSerialization {
	static String file = "helloFruits.txt";
	static ObjectOutputStream os;
	static ObjectInputStream is;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Apples a = new Apples(1, "apple");
		Apples b = new Apples(3, "apple2");
		Mango m = new Mango(2, "Mango");

		List<Object> fruits = new ArrayList<>();
		fruits.add(a);
		fruits.add(m);
		fruits.add(b);
		fruits.add(b);
		fruits.add(b);
		writeToFile(fruits);
		readFile();

	}

	public static void writeToFile(List<Object> fruits) throws IOException {
		os = new ObjectOutputStream(new FileOutputStream(file));
		os.writeObject(fruits);
		os.close();

	}

	public static void readFile() throws ClassNotFoundException, IOException {
		is = new ObjectInputStream(new FileInputStream(file));
		List<Object> input = (List<Object>) is.readObject();
		List<Object> checkList = new ArrayList<>();
		// this will contain the list of the objects
		for (Object l : input) {
			checkList.add(l.getClass().getSimpleName());
			if (l instanceof Apples) {
				Apples app = (Apples) l;
				System.out.println(app.id);
				System.out.println(app.name);
			}
			if (l instanceof Mango) {
				Mango app = (Mango) l;
				System.out.println(app.id);
				System.out.println(app.name);
			}
		}
		System.out.println(checkList);

		is.close();
	}
}

class Apples implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;

	public Apples(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class Mango implements Serializable {
	private static final long serialVersionUID = 1L;
	int id;
	String name;

	public Mango(int id, String name) {
		this.id = id;
		this.name = name;
	}
}
