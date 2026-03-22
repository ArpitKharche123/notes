package one_to_many_to_one.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import one_to_many_to_one.entities.Department;
import one_to_many_to_one.entities.Employee2;

public class FetchDepartmentAndEmployees {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence
				.createEntityManagerFactory("one_to_many_to_one");
			EntityManager em=emf.createEntityManager();
			
			List<Department> departments = em.createQuery(
			"Select d from Department d")
			.getResultList();
			if (!departments.isEmpty()) {
				for(Department d:departments) {
					System.out.println(d);
					
					List<Employee2> employees 
					= d.getEmployees();
					
					if (!employees.isEmpty()) {
						employees.stream()
						.forEach(System.out::println);
					}
					else {
						System.err.println(
			"Employees not found for the department: "
						+d.getName());
					}
				}
			}else {
				System.err.println("Departments not found");
			}
	}
}
