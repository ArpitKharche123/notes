package oto.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import oto.bi.entities.Mobile;
import oto.bi.entities.SimCard;

public class InsertMobileAndSim {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			SimCard sim=new SimCard();
			sim.setCompany("VI");
			sim.setNetworkType("5G");
			
			Mobile mobile= new Mobile();
			mobile.setBrand("Samsung");
			mobile.setColor("Grey");
			mobile.setPrice(1_20_000);
			
			sim.setMobile(mobile);
			mobile.setSim(sim);
			
			em.persist(mobile);
			em.persist(sim);
		
		et.commit();
	}
}
