package java8_e5.java8features;

@FunctionalInterface
interface FI{
	void function();
}

class Demo{
	public void method1() {
		System.out.println("Method 1");
	}
	public static void method2() {
		System.out.println("Method 2");
	}	
}

public class MethodReferences {
	public static void main(String[] args) {
		//Method reference: it is used to give 
		// existing implementation to the abstract method of
		//functional interface
		
		//obj-ref-var :: non-static method name
		Demo demo = new Demo();
		
		FI f1= demo :: method1;
		f1.function();
		
		//Classname :: static method name
		
		FI f2 = Demo :: method2;
		f2.function();
	}
}
