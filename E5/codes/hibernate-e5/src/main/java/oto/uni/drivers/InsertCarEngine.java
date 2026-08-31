package oto.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.uni.entities.Car;
import oto.uni.entities.Engine;

public class InsertCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car c = new Car();
		c.setBrand("BMW");
		c.setColor("Black");
		c.setPrice(90_00_000);
		
		Engine e = new Engine();
		e.setType("V8");
		e.setCc(900);
		
		//one-to-one mapping
		c.setEngine(e);
		
		et.begin();
			//em.persist(e);
			em.persist(c);
		et.commit();
	}
}
