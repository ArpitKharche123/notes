package drivers;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
class Person {
	private String name;
	private int age;
	private String gender;
	private double height;
	private String nationality;
}

public class BuilderPattern {
	public static void main(String[] args) {
		 Person person = Person.builder()
				 		 .age(20)
				 		 .name("Gaurav")
				 		 .gender("Male")
				 		 .height(6.1)
				 		 .nationality("Indian")
				         .build();
		 System.out.println(person);
	}
}
