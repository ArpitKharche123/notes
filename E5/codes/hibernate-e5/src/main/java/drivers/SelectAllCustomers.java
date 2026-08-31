package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SelectAllCustomers {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		//Dynamic JPQL Query
		em.createQuery("Update Customer c set c.name=?1 where c.id=:id")
		.setParameter(1, "Rohan")
		.setParameter("id", 4)
		.executeUpdate();
		
		et.commit();
		
		//select * from customers
		em.createQuery("Select c from Customer c",Customer.class)
		  .getResultList()
		  .stream()
		  .map(c-> c.getId() +" "+c.getName()+" "+c.getCity())
		  .forEach(System.out::println);
	}
}
