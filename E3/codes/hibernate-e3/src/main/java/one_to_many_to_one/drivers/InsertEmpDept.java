package one_to_many_to_one.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one_to_many_to_one.entities.Department;
import one_to_many_to_one.entities.Employee;

public class InsertEmpDept {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_many_to_one");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Department d1=new Department();
		d1.setName("Testing");
		
		Department d2=new Department();
		d2.setName("Development");
		
		Employee e1=new Employee();
		e1.setName("Ashutosh");
		e1.setBloodGroup("A+");
		e1.setGender("Male");
		
		Employee e2=new Employee();
		e2.setName("Brijesh");
		e2.setBloodGroup("B+");
		e2.setGender("Male");
		
		Employee e3=new Employee();
		e3.setName("Kavita");
		e3.setBloodGroup("AB+");
		e3.setGender("female");
		
		Employee e4=new Employee();
		e4.setName("Ravi");
		e4.setBloodGroup("O-");
		e4.setGender("Male");
		
		Employee e5=new Employee();
		e5.setName("Emily");
		e5.setBloodGroup("A-");
		e5.setGender("female");
		
		List<Employee> test = List.of(e1,e2);
		List<Employee> dev = List.of(e3,e4,e5);
		
		d1.setEmployees(test);
		d2.setEmployees(dev);
		
		test.forEach(e -> e.setDepartment(d1));
		dev.forEach(e -> e.setDepartment(d2));
		
		et.begin();
			em.persist(d1);
			em.persist(d2);
			
			test.forEach(e-> em.persist(e));
			dev.forEach(e-> em.persist(e));
		et.commit();
	}
}
