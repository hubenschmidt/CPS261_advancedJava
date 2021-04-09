package lessons;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
	private String name;
	private String major;
	private double score;

	public Student(String name, String major, double score) {
		super();
		this.name = name;
		this.major = major;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public double getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", score=" + score + "]";
	}

}

public class StudentData {
	public static void main(String[] args) {
		Student[] studentArr = { new Student("John", "CS", 87.5), new Student("Jane", "810", 92.7),
				new Student("Peter", "CS", 73) };
		// display average score by major
		Stream.of(studentArr)
				.collect(Collectors.groupingBy(e -> e.getMajor(), Collectors.averagingDouble(e -> e.getScore())))
				.forEach((k, v) -> System.out.println(k + ":" + v));

		// collect students in list
		Stream.of(studentArr).collect(Collectors.groupingBy(e -> e.getMajor()))
				.forEach((k, v) -> System.out.println(k + ":" + v));

	};

}
