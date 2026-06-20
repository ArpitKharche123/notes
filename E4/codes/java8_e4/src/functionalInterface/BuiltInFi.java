package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class BuiltInFi {
	public static void main(String[] args) {
		
		//1. 
		Function<String, Integer> length = 
				s -> s.length();
				
		Integer num = length.apply("Java");
		System.out.println(num);
		
		//2.
		UnaryOperator<Integer> sqr=
				n -> n * n;
		System.out.println(sqr.apply(6));
		 
		//3. 
		BiFunction<Integer, String, String> a=
				(id,name)->id+" : "+name;
		
		System.out.println(a.apply(1, "Jack"));
		
		//4.
		BinaryOperator<Integer> prod=
				(n1,n2)-> n1 * n2;
		System.out.println(prod.apply(12, 3));
		
		//5.
		Predicate<Integer> isEven =
				b -> b % 2 == 0;
		System.out.println(isEven.test(879));
		
		//6.
		BiPredicate<String, String> isEqual=
				(s1 ,s2)-> s1.equalsIgnoreCase(s2);
		System.out.println(isEqual.test("java", "JaVa"));
		
		//7.
		Supplier<Double> random =
				() -> Math.random() * 100;
		System.out.println(random.get());
		
		//8.
		Consumer<String> p = name -> System.out.println(name);
		p.accept("Gayatri");
		
		//9. 
		BiConsumer<Integer, Integer> sum=
				(x,y)->{
					int s=x+y;
					System.out.println(s);
				};
		sum.accept(12, 13);
		
		
		
	}
}
