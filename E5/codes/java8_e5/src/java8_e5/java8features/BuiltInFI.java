package java8_e5.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class Student{
	int id;
	String name;
	char section;
	
	public Student(int id, String name, char section) {
		super();
		this.id = id;
		this.name = name;
		this.section = section;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", section=" + section + "]";
	}
}
public class BuiltInFI {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>(
				Arrays.asList(
						new Student(1, "John", 'A'),
						new Student(3, "Michael", 'D'),
						new Student(2, "Carl", 'B'),
						new Student(4, "Nita", 'C')
						)
				);
		
		Comparator<Student> idComparator =
				(s1,s2)-> Integer.compare(s1.id, s2.id);//s1.id - s2.id
		
		Comparator<Student> nameComparator =
				(s1,s2)-> s1.name.compareTo(s2.name);
		
		Comparator<Student> descSectionComparator =
				(s1,s2)-> Character.compare(s2.section, s1.section);
				
		students.sort(descSectionComparator);
		
		students.forEach(System.out::println);
		
		Function<String, Integer> f = s -> s.length();
		System.out.println(
				f.apply("Python")
				);
		
		UnaryOperator<String> u = s -> s.toUpperCase();
		System.out.println(u.apply("LapTOP"));
		
		BiFunction<Integer, Integer, Integer> sum=
				(num1,num2) -> num1 + num2;
		sum.apply(12, 10);
		
		BinaryOperator<Integer> prod =
				(num1,num2) -> num1 * num2;
				
		Integer product = prod.apply(2, 2);
		
		Predicate<Integer> isEven =
				num -> num%2==0;
		
		System.out.println(isEven.test(3));
		
		BiPredicate<String, String> isEqual=
				(s1,s2)-> s1.equalsIgnoreCase(s2);
		
		System.out.println(isEqual.test("java", "JAVA"));
		
		Consumer<String> c = s -> System.out.println(s);
		c.accept("Smartphone");
		
		BiConsumer<Double, Double> p =
				(a,b)->System.out.println(a*b);
		p.accept(10.0, 10.0);
		
		Supplier<Double> random=
				()-> Math.random();
		
		System.out.println(random.get());
		
		
	}
}
