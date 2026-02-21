package java8;

import java.util.List;
import java.util.stream.Collectors;

class Student{
	int id;
	String name;
	List<String> skills;
	
	public Student(int id, String name, List<String> skills) {
		this.id = id;
		this.name = name;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}
	
}
public class FlatMap {
public static void main(String[] args) {
	List<Student> students=
		List.of(
				new Student(1, "Sahil",
						List.of("SQL","WebTech")),
				new Student(3, "Virat",
						List.of("SQL","Java","C#")),
				new Student(2, "Rohit",
						List.of("J2EE","Rust","Go Lang","C#")),
				new Student(5, "Hardik",
						List.of("HTML","C++")),
				new Student(4, "Sunil",
						List.of("Core Java"))
				);
		students.stream()
		.flatMap(s->s.skills.stream())
		.distinct()
		.forEach(System.out::println);
		
		//q1. Display the Student Name and its skills
		//in key value pair(use toMap())
		students.stream()
		.collect(Collectors.toMap(
				s->s,
				s->s.skills)
				)
		.forEach((k,v)->System.out.println(k.name+":"+v));
		
		System.out.println("----------------------------------------");
		
		//q2. Display Student id and no. of skills
		//in key value pair(use toMap())
		students.stream()
		.collect(Collectors.toMap(
				s->s.id,
				s->s.skills.size())
				)
		.forEach((k,v)->System.out.println(k+":"+v));
		
		System.out.println("----------------------------------------");
		
		//q3. Sort students list in desc based 
		//on no. of skills
		//and Display student details
		students.stream()
		.sorted((s1,s2)->
		Integer.compare(s2.skills.size(),s1.skills.size()))
		.forEach(System.out::println);
	}
}
