package o2o.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.uni.entities.Car;

public class TestOrphanRemoval {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		et.begin();
			Car car = em.find(Car.class, 1);
			
			car.setEngine(null);//break mapping between Car and Engine
		et.commit();
	}
}
