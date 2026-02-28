package java8;

@FunctionalInterface
interface I1{
	void m();//Single Abstract method(SAM)
}
@FunctionalInterface
interface I2{
	void m(String s);
}
@FunctionalInterface
interface I3{
	double square(double num);
}
@FunctionalInterface
interface I4{
	double sum(double n1,double n2,
			double ... nums);
}

public class DemoDriver {
	public static void main(String[] args) {
		//Using anonymous inner type
		//More boilerplate code !
		//Less readable !
		I1 i = new I1() {
			@Override
			public void m() {
				System.out.println("m1");
			}
		};
		
		//Using lamda expressions
		//Less boilerplate code !
		//More readable !
		I1 i1 = ()->
		System.out.println("m1 using lambda");
		i1.m();
		
		I2 i2 = string ->System.out.println(string);
		i2.m("Lamda");
		
		I3 i3 = num -> num * num;
		System.out.println(i3.square(10));
		
		I4 i4= (num1,num2,numsArray)->
		{
			double sum = num1+num2;
			for(double n:numsArray) {
				sum+=n;
			}
			return sum;
		};
		System.out.println(i4.sum(1, 2));
		System.out.println(i4.sum(10, 20, 30));
		System.out.println(i4.sum(10, 20, 30, 40, 50));
	}
}
