package oto.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import oto.bi.entities.Mobile;
import oto.bi.entities.SimCard;

public class FetchMobileAndSim {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence
				.createEntityManagerFactory("one_to_one");
		EntityManager em=emf.createEntityManager();
		
		//Fetching sim using mobile object
		Mobile mobile=em.find(Mobile.class, 1);
		if (mobile!=null) {
			System.out.println(mobile);
			System.out.println(mobile.getSim());
		}else {
			System.err.println("Mobile not found");
		}
		
		//Fetching Mobile using Sim object
		SimCard sim=em.find(SimCard.class, 1);
		if (sim!=null) {
			System.out.println(sim);
			System.out.println(sim.getMobile());
		}else {
			System.err.println("Sim not found");
		}

	}
}
