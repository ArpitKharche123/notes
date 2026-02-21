package java8;

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

class Employee {
	int id;
	String name;
	int age;

	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}

public class BuiltInFunctionalInterfaces {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>(Arrays.asList(new Employee(1, "Smith", 34),
				new Employee(3, "Harshad", 41), new Employee(2, "Dinesh", 24), new Employee(4, "Girish", 54)));

		Comparator<Employee> ageComparator = (e1, e2) -> Integer.compare(e2.age, e1.age);

		Comparator<Employee> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);

		employees.sort(nameComparator);

		employees.sort((e1, e2) -> Integer.compare(e1.id, e2.id));
		// Built in Higher order function
		employees.forEach(System.out::println);

		Function<String, Integer> function = s -> s.length();
		System.out.println(function.apply("Mahabharat"));

		UnaryOperator<Double> cube = num -> Math.pow(num, 3);
		System.out.println(cube.apply(10.0));

		BiFunction<Integer, Double, Double> total = (quantity, price) -> quantity * price;

		System.out.println(total.apply(10, 23.5));

		BinaryOperator<Double> sum = (num1, num2) -> num1 + num2;

		System.out.println(sum.apply(12.3, 1.7));

		Predicate<Integer> isEven = num -> num % 2 == 0;
		System.out.println(isEven.test(21));

		BiPredicate<String, String> isEqual = (s1, s2) -> s1.equalsIgnoreCase(s2);

		System.out.println(isEqual.test("java", "JaVa"));

		Consumer<String> display = s -> System.out.println(s);
		display.accept("Advance Java");

		BiConsumer<Integer, Integer> table = (num, multiple) -> {
			for (int i = 1; i <= multiple; i++) {
				System.out.println(num + " x " + i + " = " + num * i);
			}
		};
		table.accept(10, 10);

		Supplier<Double> supplier = () -> Math.random();

		System.out.println(supplier.get());
	}
}
