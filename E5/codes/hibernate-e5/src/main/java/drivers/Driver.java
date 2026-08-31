package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("hibernate");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		//Fetch a single record
		Customer customer = em.find(Customer.class, 1);
		
		//Update
		et.begin();
//		 if(customer!=null) {
//			 customer.setCity("Mumbai");
//		 }else {
//			 System.err.println("Customer not found!!");
//		 }
//		 System.out.println(customer);
		 
		 
		 //Remove
		 em.remove(customer);
		 
		et.commit();
	}
}
