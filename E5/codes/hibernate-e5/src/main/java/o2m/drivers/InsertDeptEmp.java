package o2m.drivers;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2m.entities.Department;
import o2m.entities.Employee;

public class InsertDeptEmp {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department d1 = new Department();
		d1.setName("Development");
		
		Department d2 = new Department();
		d2.setName("Testing");
		
		Employee e1 = new Employee();
		e1.setName("Joe");
		e1.setEmail("joe@gmail.com");
		
		Employee e2 = new Employee();
		e2.setName("Martin");
		e2.setEmail("martin@gmail.com");
		
		Employee e3 = new Employee();
		e3.setName("Jack");
		e3.setEmail("jack@gmail.com");
		
		Employee e4 = new Employee();
		e4.setName("Alice");
		e4.setEmail("alice@gmail.com");
		
		Employee e5 = new Employee();;
		e5.setName("Bob");
		e5.setEmail("bob@gmail.com");
		
		//One-to-many mapping
		List<Employee> emps1 = Arrays.asList(e1,e2,e3);
		List<Employee> emps2 = Arrays.asList(e4,e5);
		
		d1.setEmployees(emps1);
		d2.setEmployees(emps2);
	
		et.begin();
			emps1.forEach(e -> em.persist(e));
			emps2.forEach(e -> em.persist(e));
			em.persist(d1);
			em.persist(d2);
		et.commit();
	}
}
