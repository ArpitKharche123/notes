package oto.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.uni.entities.Car;
import oto.uni.entities.Engine;

public class InsertCarAndEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Engine e = new Engine();
		e.setCc(800);
		e.setType("Petrol");

		Car car = new Car();
		car.setBrand("BMW");
		car.setColor("Black");
		car.setEngine(e);

	try {
		et.begin();
		em.persist(e);
		em.persist(car);
		et.commit();
	} catch (Exception e2) {
		if (et.isActive()) {
			et.rollback();
			//Roll backs the transaction
			e2.printStackTrace();
		}
	}
	}
}
