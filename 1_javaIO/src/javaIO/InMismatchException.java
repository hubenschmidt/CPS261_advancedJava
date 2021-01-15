package javaIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InMismatchException {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter Integer Value: ");
			Integer inputInt = scanner.nextInt(); // input : "12222222222222222"
			System.out.println(inputInt);

		} catch (InputMismatchException ex) {
			System.out.println("input is not with in integer range " + ex);
		}
	}
}