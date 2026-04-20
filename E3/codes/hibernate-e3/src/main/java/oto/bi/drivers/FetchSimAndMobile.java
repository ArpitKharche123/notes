package oto.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import oto.bi.entities.Mobile;
import oto.bi.entities.SimCard;

public class FetchSimAndMobile {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em=emf.createEntityManager();
		
		Mobile mobile = em.find(Mobile.class, 1);
		if (mobile!=null) {
			SimCard sim = mobile.getSim();
			if(sim!=null) {
				System.out.println(sim.getOperator());
			}else {
				System.err.println("Sim not found");
			}
		}else {
			System.err.println("Mobile not found");
		}
	}
}
