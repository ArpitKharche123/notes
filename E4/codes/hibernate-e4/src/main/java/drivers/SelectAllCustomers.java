package drivers;

import java.util.List;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class SelectAllCustomers {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate");
			
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("Select c from Customer c",
				Customer.class);
		
		List<Customer> list = query.getResultList();
		
		list.forEach(System.out::println);
		//or
		
		em.createQuery("from Customer c",Customer.class)
		  .getResultList()
		  .forEach(System.out::println);
		
	}
}
