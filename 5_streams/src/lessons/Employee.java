package lessons;

import java.util.Arrays;

public class Employee {

	public static void main(String[] args) {
		Employee[] emps = { "Jack", "Jill", "Jamie", "Jon", "Johanna", "Jessie" };
		
		Arrays.stream(emps).filter(e -> e.getSalary()>=2500)
			
		
	}

}
