package java_8;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface FI{
	void m();
}
public class HOFDriver {
	//Higher Order Function(HOF)
	static void test(FI f) {
		f.m();
	}
	
	void nsMethod() {
		System.out.println("Non Static Method");
	}
	
	static void staticMethod() {
		System.out.println("Static Method");
	}
	
	public static void main(String[] args) {
		
		FI f= ()->System.out.println("HOF");
		
		//We can pass our own method 
		//body/implementation of single
		//abstract method
		//while calling a higher order function
		test(f);
		test(()->System.out.println("HOF2"));
		
		//Method Reference
		
		//We can pass the method body which is 
		//already present to the HOF
		//Using Method References
		
		//If their method header matches!!
		
		HOFDriver d=new HOFDriver();
		
		//For passing a non-static method
		//obj-reference::methodName
		test(d::nsMethod);
		//or
		test(new HOFDriver()::nsMethod);
		
		//For passing a static method
		//ClassName::methodName
		test(HOFDriver::staticMethod);
		
		//Built in HOF
		List<Integer> list= Arrays.asList(1,2,3,4);
		
		list.forEach(e->System.out.println(e));
		
		list.forEach(System.out::print);
	}
}
