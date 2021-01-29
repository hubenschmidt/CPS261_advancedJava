package comparableInterface;

public class ComparableInterface {

	public static void main(String[] args) {
		Student s1 = new Student("Joe", 9, 3.5);
		Student s2 = new Student("Bob", 12, 3.7);

//		System.out.println(s1.equals(s2));

		System.out.println("Compare to Returns : " + s1.compareTo(s2));
		int result = s1.compareTo(s2);

		if (result > 0) {
			System.out.println(s1.getName() + " comes before " + s2.getName());
		} else if (result > 0)
			System.out.println();

	}

}
