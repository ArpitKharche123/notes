package one_to_many_to_one.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import one_to_many_to_one.entities.Department;
import one_to_many_to_one.entities.Employee2;

public class InsertEmployeeAndDepartment {
	public static void main(String[] args) {
		EntityManagerFactory emf=
			Persistence
			.createEntityManagerFactory("one_to_many_to_one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Department dept=new Department();
		dept.setName("development");
		
		Department dept2=new Department();
		dept2.setName("testing");
		
		Employee2 emp1=new Employee2();
		emp1.setName("Kabir");
		emp1.setEmail("kabir@gmail.com");
		emp1.setBloodGroup("A+");
		emp1.setDept(dept);
		
		Employee2 emp2=new Employee2();
		emp2.setName("priti");
		emp2.setEmail("priti@gmail.com");
		emp2.setBloodGroup("B-");
		emp2.setDept(dept);
		
		Employee2 emp3=new Employee2();
		emp3.setName("dipti");
		emp3.setEmail("dipti@gmail.com");
		emp3.setBloodGroup("O+");
		emp3.setDept(dept2);
		
		Employee2 emp4=new Employee2();
		emp4.setName("pravin");
		emp4.setEmail("pravin@gmail.com");
		emp4.setBloodGroup("AB+");
		emp4.setDept(dept2);
		
		Employee2 emp5=new Employee2();
		emp5.setName("abhay");
		emp5.setEmail("abhay@gmail.com");
		emp5.setBloodGroup("O-");
		emp5.setDept(dept2);
		
		dept.setEmployees(List.of(emp1,emp2));
		dept2.setEmployees(List.of(emp3,emp4,emp5));
		
		try {
			et.begin();
			em.persist(dept);
			em.persist(dept2);
			et.commit();
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		}
		
	}
}
