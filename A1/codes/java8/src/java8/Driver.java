package java8;

interface I{
	void m();
	//default method
	default void defaultMethod() {
		System.out.println("default method");
	}
	//static method
	static void staticMethod() {
		System.out.println("static method");
	}
}

public class Driver implements I {
	public static void main(String[] args) {
		I i = new Driver();
		Driver d = new Driver();
		
		i.defaultMethod();
		d.defaultMethod();
		
		I.staticMethod();
	}
	
	@Override
	public void m() {
		// TODO Auto-generated method stub
		
	}

}
