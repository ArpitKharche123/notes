package o2o.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.bi.entities.Mobile;
import o2o.bi.entities.SimCard;

public class InsertMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory emf =
		Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Mobile mobile = new Mobile();
		mobile.setBrand("Redmi");
		mobile.setModel("Note 10");
		mobile.setPrice(15000);
		
		SimCard card= new SimCard();
		card.setBrand("Jio");
		card.setType("micro");
		
		//one-to-one bi-directional mapping
		mobile.setSim(card);
		card.setMobile(mobile);
		
		et.begin();
			em.persist(mobile);
			em.persist(card);
		et.commit();
	}
	
}
