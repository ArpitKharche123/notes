package functionalInterface;

interface Demo{
	void m();
}

class Test{
	void instanceMethod() {
		System.out.println("non-static method");
	}
	static void staticMethod() {
		System.out.println("static method");
	}
}

public class MethodReference {
	public static void main(String[] args) {
		//Method references
		// - used to provide existing implementation to 
		//single abstract method of functional interface
		
		//non-static method
		// instance/reference :: n.s. method name
		Test t = new Test();
		Demo d = t :: instanceMethod;
		d.m();
		
		//static method
		// Classname :: static method name
		Demo d2 = Test :: staticMethod;
		d2.m();
	}
}
