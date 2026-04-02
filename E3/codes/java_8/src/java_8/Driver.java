package java_8;
//Functional Interface

@FunctionalInterface
interface Demo{
	void m();//Single Abstract Method(SAM)
}

interface I1{
	void display(String name);
}

interface I2{
	double sum(double a,double b);
}

interface I3{
	void method(int a);
}

public class Driver {
	public static void main(String[] args) {
		//Anonymous Inner Class
		Demo d=new Demo() {
			@Override
			public void m() {
				System.out.println("Implementation 1");
			}
		};
		
		//Lambda Expression
		// ()->{}
		Demo d2= ()->{ 
			System.out.println("Implementation 2");
		};
		
		//using {} is optional if method
		// is having only one statement
		
		Demo d3= ()->
		System.out.println("Implementation 3");
		
		d3.m();
		d2.m();
		
		//using () is optional if method
		// is having only one formal argument
		
		I1 i1= n -> System.out.println(n);
		i1.display("Hello Everyone");
		
		I2 i2=(num1,num2)->{
			double sum=num1+num2;
			return sum;
		};
		
		i2= (n1,n2)->n1+n2;	
		
		i2.sum(12.4, 10.3);
		
		I3 i3= a -> System.out.println(a);
		i3.method(12);
	}
}
