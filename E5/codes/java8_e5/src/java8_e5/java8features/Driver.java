package java8_e5.java8features;

//Functional Interface
@FunctionalInterface
interface A {
	// Single Abstract method
	void m();
}

interface B {
	void print(String s);
}

interface C {
	public double sum(double a, double b);
}

public class Driver {
	public static void main(String[] args) {
		// Using Anonymous Inner Class/Type
		A a = new A() {
			@Override
			public void m() {
				System.out.println("Impl 1");
			}
		};
		a.m();

		// Using lambda expression
		// ()->{}
		A a1 = () -> {
			int num1 = 10, num2 = 20;
			System.out.println(num1 + num2);
		};
		a1.m();
		// {} can be skipped if method body is having
		// only one statement
		a1 = () -> System.out.println("Hello");

		// () can be skipped if method is having
		// exactly one formal argument
		B b = string -> System.out.println(string);

		b.print("We are learning java8 features");

		C c = (n1, n2) -> {
			double sum = n1 + n2;
			return sum;
		};

		c = (n1, n2) -> n1 + n2;
		
		System.out.println(c.sum(12, 13));

	}
}
