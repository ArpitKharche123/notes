package java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
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
	int age;
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
public class BuiltInFI {
	public static void main(String[] args) {
List<Student> students=
		new ArrayList<>(
			Arrays.asList(
				new Student(1, "Sarthak", 21),
				new Student(3, "Chetan",22 ),
				new Student(2, "Gauri", 20),
				new Student(4, "Dipti", 19))	
				);

		Comparator<Student> ageComparator
		= (s1,s2)-> s1.age-s2.age;
		
		ageComparator=
		(s1,s2)-> Integer.compare(s2.age, s1.age);
		
		Comparator<Student> nameComparator
		=(s1,s2)-> s1.name.compareTo(s2.name);
		
		students.sort(nameComparator);
		students.forEach(System.out::println);
		
		Function<String, Integer> fun
		= s -> s.length();
		
		System.out.println(fun.apply("Functional Interface"));
		
		UnaryOperator<String> un
		= s -> s.toUpperCase();
		
		System.out.println(un.apply("lAPTop"));
		
		BiFunction<String, Integer, String> biF
		= (name,age)->name+" is "+age+" years old";
		
		System.out.println(biF.apply("Smith", 23));
		
		BinaryOperator<Double> sum
		= (n1,n2)->n1+n2;
		
		System.out.println(sum.apply(1.0,12.5));
		
		Predicate<Integer> isEven=
				n-> n%2==0;
				
		System.out.println(isEven.test(23));
		
		BiPredicate<String, String> isEqual
		= (s1,s2)->s1.equalsIgnoreCase(s2);
		
		System.out.println(isEqual.test("JaVa", "jAvA"));
		
		Consumer<String> con
		=s->{
			s=s.toLowerCase();
			System.out.println(s);
		};
		
		con.accept("Good Night");
		
		BiConsumer<Double,Double > biC
		=(n1,n2)->System.out.println("Product: "+n1*n2);
		
		biC.accept(12.3, 23.7);
		
		Supplier<Double> sup
		= ()->Math.random();
		
		System.out.println(sup.get());
		
		Runnable r=()->System.out.println("Demo");
		r.run();
		
		Callable<String> callable
		=()-> "Bye Bye";
		
		try {
			System.out.println(callable.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
