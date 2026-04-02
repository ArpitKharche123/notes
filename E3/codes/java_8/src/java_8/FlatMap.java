package java_8;

import java.util.Arrays;
import java.util.List;

class Car{
	int id;
	String brand;
	List<String> tyres;
	public Car(int id, String brand, List<String> tyres) {
		this.id = id;
		this.brand = brand;
		this.tyres = tyres;
	}
	
}

public class FlatMap {
	public static void main(String[] args) {
		List<Car> cars=
		Arrays.asList(
				new Car(1, "BMW",
						Arrays.asList("Hero","MRF","Yokohama")),
				new Car(2, "Audi",
						Arrays.asList("Hero","MRF","CEAT"))
				);
		
		cars.stream()
		//.map(c->c.tyres) //it will consider tyres list
		.flatMap(c->c.tyres.stream())//elements present in tyres list
		.distinct()
		.forEach(System.out::println);
		
	}
}
