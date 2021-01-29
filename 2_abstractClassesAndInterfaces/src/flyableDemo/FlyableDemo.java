package flyableDemo;

import java.util.ArrayList;

interface Flyable {
	public void fly(); // abstract method
}

class Bird implements Flyable { // implements can be used on multiple interfaces
	public void fly() {
		System.out.println("I fly like a bird.");
	}
}

class Bat implements Flyable { // implements can be used on multiple interfaces
	public void fly() {
		System.out.println("I fly like a bat.");
	}
}

class Plane implements Flyable { // implements can be used on multiple interfaces
	public void fly() {
		System.out.println("I fly like a plane.");
	}
}

public class FlyableDemo {
	public static void main(String[] args) {
		ArrayList<Flyable> flyableObj = new ArrayList<>();
		flyableObj.add(new Bird());
		flyableObj.add(new Bat());
		flyableObj.add(new Plane());

		for (Flyable flyable : flyableObj) {
			flyable.fly();
		}
	}
}