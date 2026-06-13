package functionalInterface;

//functional interface
//- interface which is having only one declared abstract method 
@FunctionalInterface
interface I1 {
	void m();// Single Abstract Method
}

interface I2 {
	void m(int a);
}

interface I3{
	double sum(double a,double b);
}

public class FIDriver {
	public static void main(String[] args) {
		// Anonymous inner type
		I1 i1 = new I1() {
			@Override
			public void m() {
				System.out.println("anonymous");
			}
		};
		i1.m();

		// Lambda expression -to provide implementation to
		// SAM present in Functional interface
		// () -> {}

		// Using {} is optional if method body is having only
		// one statement
		i1 = () -> System.out.println("implementation of m()");
		i1.m();
		
		//If method is having only one formal argument,
		//we can skip using ()
		I2 i2 = a -> System.out.println(a);
		i2.m(12);
		
		I3 i3= (n1,n2) ->{
			double sum = n1 + n2;
			return sum;
		};
		
		i3 = (n1,n2) -> n1+n2; //directly returning the sum
		
		System.out.println(i3.sum(12, 12.5));
	}
}
