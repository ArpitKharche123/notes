package java8_e5.java8features;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface I1 {
	void m();
}

public class HOF {

	// Higher Order Function
	// - a method which either returns or accepts the reference of 
	//   a functional interface
	public static void test(I1 i) {
		i.m();
	}

	public static void demo() {
		System.out.println("hof");
	}
	public static void main(String[] args) {
		I1 i = () -> System.out.println("test");
		HOF.test(i);
		
		HOF.test(
				()->System.out.println("demo")
				);
		
		HOF.test(HOF::demo);
		
		//Example:
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		list.forEach(  
				num -> System.out.print(num+" ")
				);
		list.forEach( System.out :: println);
	}
}
