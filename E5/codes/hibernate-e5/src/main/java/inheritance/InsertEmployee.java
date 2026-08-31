package inheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		FullTimeEmployee e1 = new FullTimeEmployee();
		e1.setName("Richard");
		e1.setEmail("rich@gmail.com");
		e1.setSalary(30_00_000);
		e1.setExp(3.5);
		
		PartTimeEmployee e2 = new PartTimeEmployee();
		e2.setName("Jackson");
		e2.setEmail("jack@gmail.com");
		e2.setDurationInMonths(6);
		e2.setFixedPay(10_00_000);
		
		et.begin();
			em.persist(e1);
			em.persist(e2);
		et.commit();
	}
}
