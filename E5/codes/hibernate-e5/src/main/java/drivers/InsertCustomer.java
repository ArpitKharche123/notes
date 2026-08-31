package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertCustomer {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		
		//Only required for DML operations
		EntityTransaction et = em.getTransaction();
		
		Customer c1 = new Customer();
		c1.setName("Ankush");
		c1.setEmail("ankush@gmail.com");
		c1.setCity("Pune");
		
		Customer c2 = new Customer();
		c2.setName("Aniket");
		c2.setEmail("aniket@gmail.com");
		c2.setCity("Nashik");
		
		Customer c3 = new Customer();
		c3.setName("Aman");
		c3.setEmail("aman@gmail.com");
		c3.setCity("Nagpur");
		
		et.begin();
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
		et.commit();
	}
}
