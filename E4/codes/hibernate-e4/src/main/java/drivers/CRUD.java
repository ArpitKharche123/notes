package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CRUD {
	public static void main(String[] args) {
		EntityManagerFactory emf=
			Persistence.createEntityManagerFactory("hibernate");
		
		EntityManager em = emf.createEntityManager();
		
		//et is required only for DML operations
		EntityTransaction et = em.getTransaction();
		
		//Inserting a record
		Customer c = new Customer();
		c.setName("Nisha");
		c.setEmail("n@gmail.com");
		c.setAddress("PCMC");
		
		//et.begin();
			//em.persist(c);//insert
		//et.commit();
		
		//Fetch a record
		Customer customer = em.find(Customer.class, 1);
		System.out.println(customer);
		
		//Update a record
		et.begin();
			//Fetch the record to be updated
		Customer c2 = em.find(Customer.class, 1);
		
		if (c2!=null) {
			c2.setName("Sahil");
			c2.setEmail("sahil@gmail.com");
		}
		
		//Deleting a record
		
		//Find the record to be deleted
		Customer c3 = em.find(Customer.class, 1);
		em.remove(c3);
		
		et.commit();
	}
}
