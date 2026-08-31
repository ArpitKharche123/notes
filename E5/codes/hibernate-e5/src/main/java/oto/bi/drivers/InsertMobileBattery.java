package oto.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.bi.entities.Battery;
import oto.bi.entities.Mobile;

public class InsertMobileBattery {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Mobile m = new Mobile();
		m.setModel("S26 Ultra");
		m.setBrand("Samsung");
		m.setPrice(1_50_000);
		
		Battery b = new Battery();
		b.setBrand("Samsung");
		b.setCapacity("5000mAh");

		//one-to-one bi
		m.setBattery(b);
		b.setMobile(m);
		
		et.begin();
			em.persist(b);
			em.persist(m);
		et.commit();
	}
}
