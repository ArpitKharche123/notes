package drivers;

import entities.FullTimeEmployee;
import entities.PartTimeEmployee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("hibernate");
				
		EntityManager em=emf.createEntityManager();
				
		EntityTransaction et=em.getTransaction();
		
		PartTimeEmployee e1=new PartTimeEmployee();
		e1.setName("Jack");
		e1.setGender("Male");
		e1.setDurationInMonths(6);
		e1.setPay(30000);
		
		FullTimeEmployee e2=new FullTimeEmployee();
		e2.setName("Emily");
		e2.setGender("Female");
		e2.setSalary("10lpa");
		e2.setBonus(10);
		e2.setYearOfExp(3);
		
		et.begin();
			em.persist(e1);
			em.persist(e2);
		et.commit();
	}
}
