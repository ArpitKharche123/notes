package functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student{
	int id;
	String name;
	List<String> skills;
	
	public Student(int id, String name, List<String> skills) {
		this.id = id;
		this.name = name;
		this.skills = skills;
	}
	
}
public class FlatMap {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>(
				Arrays.asList(
						new Student(1, "Om",
							Arrays.asList("java","sql") ),
						new Student(2, "Ram",
								Arrays.asList("java","python") ),
						new Student(2, "Jack",
								Arrays.asList("python","sql") )
						)
				);
		
		students.stream()
				//.map(s->s.skills)  //considers the list
				.flatMap(s->s.skills.stream()) //consider the elements
				.distinct()
				.forEach(System.out::println);
	}
}
