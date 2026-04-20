package oto.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.bi.entities.Mobile;
import oto.bi.entities.SimCard;

public class InsertMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Mobile mobile=new Mobile();
		mobile.setBrand("Samsung");
		mobile.setProcessor("Exynos");
		mobile.setPrice(70000);
		
		SimCard sim=new SimCard();
		sim.setOperator("JIO");
		sim.setType("5G");
		
		mobile.setSim(sim);
		sim.setMobile(mobile);
		
		et.begin();
			em.persist(sim);
			em.persist(mobile);
		et.commit();
	}
}
