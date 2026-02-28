package java8;

import java.util.List;

@FunctionalInterface
interface FI{
	void m();
}
public class HOF {
	//Higher order function
	static void hof(FI fi) {
		fi.m();
	}
	
	static void staticMethod() {
		System.out.println("Static Method");
	}
	
	void nsMethod() {
		System.out.println("Non static Method");
	}
	
	public static void main(String[] args) {
//		HOF.hof(
//				()->System.out.println("Demo")
//			);
//		//Method references
//		
//		HOF.hof(HOF::staticMethod);
//		
//		HOF h= new HOF();
//		HOF.hof(h::nsMethod);
//		
//		HOF.hof(new HOF()::nsMethod);
		
		List<Integer> list= List.of(1,2,3,4,5,6);
		//Built in hof
		list.forEach(
				i->System.out.println(i)
				);
		list.forEach(System.out::print);
	}
}
