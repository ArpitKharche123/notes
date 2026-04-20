package m2m.bi.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.bi.entities.Subject;
import m2m.bi.entities.Trainer;

public class InsertTrainerSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_many");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Trainer t1=new Trainer();
		t1.setName("Harshavardhan");
		t1.setPhone(7338763523l);
		
		Trainer t2=new Trainer();
		t2.setName("Collin");
		t2.setPhone(7338453523l);
		
		Trainer t3=new Trainer();
		t3.setName("Abhishek");
		t3.setPhone(9338763523l);
		
		Subject s1=new Subject();
		s1.setName("Java");
		s1.setDuration("5 months");
		s1.setFees(17000);
		
		Subject s2=new Subject();
		s2.setName("SQL");
		s2.setDuration("2 months");
		s2.setFees(7000);
		
		Subject s3=new Subject();
		s3.setName("Manual");
		s3.setDuration("3 months");
		s3.setFees(11000);
		
		t1.setSubjects(List.of(s1,s2));
		t2.setSubjects(List.of(s2,s3));
		t3.setSubjects(List.of(s1,s3));
		
		s1.setTrainers(List.of(t1,t3));
		s2.setTrainers(List.of(t1,t2));
		s3.setTrainers(List.of(t2,t3));
		
		et.begin();
			List.of(s1,s2,s3).forEach(s->em.persist(s));
			List.of(t1,t2,t3).forEach(t->em.persist(t));
		et.commit();
	}
}
