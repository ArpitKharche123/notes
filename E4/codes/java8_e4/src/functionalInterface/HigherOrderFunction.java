package functionalInterface;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Test1{
	void m();
}
class MyClass{
	//higher order function
	//- method which accepts or returns the Functional Interface
	// type of varible
	
	//We can pass implementation/logic directly to the
	//method call statement
	static void hof(Test1 t) {
		t.m();
	}
}

public class HigherOrderFunction {
	public static void main(String[] args) {
		
		Test1 t1= ()->System.out.println("Hello Everyone");
		MyClass.hof(t1);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		list.forEach(System.out :: println);
		//or
		list.forEach(num->System.out.print(num+" "));
	}
}
