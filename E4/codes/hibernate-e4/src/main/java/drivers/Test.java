package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate");
			
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Customer c1 = new Customer();
		c1.setName("Dipti");
		c1.setEmail("dip@yahoo.com");
		c1.setAddress("Wakad");
		
		Customer c2 = new Customer();
		c2.setName("Eknath");
		c2.setEmail("Ek@yahoo.com");
		c2.setAddress("Kalewadi Phata");
		
		Customer c3 = new Customer();
		c3.setName("Babloo");
		c3.setEmail("babloo@yahoo.com");
		c3.setAddress("Nagpur");
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		
		et.commit();
	}
}
