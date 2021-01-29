package genericDemo;

import java.util.ArrayList;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> myList = new ArrayList<>();
//		ArrayList myList = new ArrayList(); 	// using Object -- the "raw type"
		myList.add(1);
		myList.add(2);
		myList.add(3);

		for (Integer object : myList) {
			System.out.println((int) object * 2); // example of using casting to cast Object raw type to integer.
		}
	}
}
