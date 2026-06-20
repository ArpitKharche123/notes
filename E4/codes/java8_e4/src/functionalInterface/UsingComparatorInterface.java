package functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employee{
	int id;
	String name;
	double salary;
	
	//AllArgsConstructor
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

public class UsingComparatorInterface {
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>(
				Arrays.asList(
						new Employee(1, "Rochak", 50000.8),
						new Employee(2, "Prathamesh", 80000.0),
						new Employee(3, "Tejas", 10000.0),
						new Employee(4, "Eknath", 15000.50)
						)
				);
		
		emps.forEach( emp ->
				System.out.println(
						"Id: "+emp.id+
						"\nName: "+emp.name+"\n")
				);
		
		Comparator<Employee> nameComparator=
			(e1,e2)-> e1.name.compareTo(e2.name);
		
		//Sorting the emps list in ascending order
		//based on employee name
		emps.sort(nameComparator);
		
		//emps.forEach(System.out::println);
		
		//Sorting in descending order based on id
		emps.sort((emp1,emp2) -> emp2.id - emp1.id);
		
		//emps.forEach(System.out::println);
		
		emps.sort((empl1,empl2)
				-> Double.compare(empl1.salary, empl2.salary) );
		
		emps.forEach(System.out::println);
		
	
	}
}
