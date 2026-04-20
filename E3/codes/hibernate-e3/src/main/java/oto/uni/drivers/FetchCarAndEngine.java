package oto.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import oto.uni.entities.Car;

public class FetchCarAndEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_one");
		
		EntityManager em=emf.createEntityManager();
		
		Car car = em.find(Car.class, 1);
		Car c2= em.find(Car.class, 1);
		
		if(car!=null) {
			//System.out.println(car);
			//System.out.println(car.getEngine());
		}else {
			System.err.println("Car not found");
		}
	}
}
