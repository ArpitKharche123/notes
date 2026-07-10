package o2o.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.uni.entities.Car;
import o2o.uni.entities.Engine;

public class CarEngineDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf=
	Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		Engine e = new Engine();
		e.setCc(800);
		e.setTorque(60);
		e.setType("Petrol");
		
		Car c= new Car();
		c.setBrand("BMW");
		c.setColor("Blue");
		c.setPrice(12_00_000);
		
		c.setEngine(e);//establishing mapping
		
		et.begin();
			em.persist(e);
			em.persist(c);
		et.commit();
		
		//fetch the car object using find
		// c!=null   c.getEngine()
	}
}
