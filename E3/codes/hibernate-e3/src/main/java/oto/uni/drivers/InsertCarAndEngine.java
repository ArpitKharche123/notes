package oto.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.uni.entities.Car;
import oto.uni.entities.Engine;

public class InsertCarAndEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_one");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			
		Engine e=new Engine();
		e.setCc(890);
		e.setType("Petrol");
		
		Car car=new Car();
		car.setBrand("BMW");
		car.setColor("Black");
		car.setPrice(1200000);
		car.setEngine(e);
		
		em.persist(e);
		em.persist(car);
		System.out.println("Saved");
		
		et.commit();
	}
}
