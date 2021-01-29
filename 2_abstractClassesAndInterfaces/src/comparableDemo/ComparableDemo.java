package comparableDemo;

class Pet implements Comparable<Pet> {
	String name;
	int age;

	@Override
	public String toString() {
		return "Pet [name=" + name + ", age=" + age + "]";
	}

	public Pet(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Pet otherPet) {
		return name.compareTo(otherPet.name);
	}
}

public class ComparableDemo {

}
