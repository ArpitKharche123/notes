package one_to_many_to_one.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import one_to_many_to_one.entities.Department;
import one_to_many_to_one.entities.Employee;

public class FetchEmpDept {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_many_to_one");
		EntityManager em=emf.createEntityManager();
		
		 List<Department> departments 
		 = em.createQuery("Select d from Department d join fetch d.employees"
				 ,Department.class)
			.getResultList();
		 if(!departments.isEmpty()) {
			 for(Department d:departments) {
				 System.out.println("Dept: "+d.getName());
				 
		 List<Employee> employees = d.getEmployees();
		 
		 if(!employees.isEmpty()) {
			 System.out.println("Employees: ");
			 for(Employee e:employees) {
				 System.out.println(e.getName());
			 }
		 }
		 else {
			 System.err.println("Employees not found for department: "+d.getName());
		 }
			 }
		 }
		 else {
			 System.err.println("No Departments found");
		 }
	}
}
