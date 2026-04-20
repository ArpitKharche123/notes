package oto.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.uni.entities.Laptop;

public class RemoveLaptopCharger {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_one");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Laptop laptop = em.find(Laptop.class, 1);
		
		//disconnecting the laptop and charger object
		laptop.setCharger(null);

		
		et.begin();
			//em.remove(laptop);
		et.commit();
	}
}
