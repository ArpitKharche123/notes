package oto.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.uni.entities.Charger;
import oto.uni.entities.Laptop;

public class InsertLaptopCharger {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("one_to_one");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Laptop l=new Laptop();
		l.setModel("katana");
		l.setBrand("msi");
		l.setPrice(23000);
		
		Charger c=new Charger();
		c.setWatts(180);
		c.setPinType("USB type");
		
		l.setCharger(c);
		
		et.begin();
			em.persist(l);
		et.commit();
	}
}
