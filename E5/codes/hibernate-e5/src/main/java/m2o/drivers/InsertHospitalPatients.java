package m2o.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2o.entities.Hospital;
import m2o.entities.Patient;

public class InsertHospitalPatients {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("many_to_one");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Patient p1 = new Patient();
		p1.setName("Pranav");
		p1.setAge(23);
		p1.setWeight(65.6);
		
		Patient p2 = new Patient();
		p2.setName("Anjali");
		p2.setAge(21);
		p2.setWeight(55.6);
		
		Hospital h = new Hospital();
		h.setName("Mamta Hospital");
		h.setLocation("The HUB building, 6th floor");
		h.setType("Maternity");
		
		//many-to-one mapping
		p1.setHospital(h);
		p2.setHospital(h);
		
		et.begin();
			em.persist(h);
			em.persist(p1);
			em.persist(p2);
		et.commit();
	}
}
