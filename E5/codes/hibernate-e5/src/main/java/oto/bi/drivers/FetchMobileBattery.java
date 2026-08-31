package oto.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import oto.bi.entities.Battery;
import oto.bi.entities.Mobile;

public class FetchMobileBattery {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("one_to_one");
		EntityManager em = emf.createEntityManager();
		
		Mobile mobile = em.find(Mobile.class, 1);
		
		if(mobile!=null) {
			
			System.out.println("Model: "+mobile.getModel() );
			Battery battery = mobile.getBattery();
			
			System.out.println("Capacity: "+battery.getCapacity());
		}
	}
}	
