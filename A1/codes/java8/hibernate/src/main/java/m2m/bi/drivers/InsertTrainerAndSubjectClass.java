package m2m.bi.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.bi.entities.Subject2;
import m2m.bi.entities.Trainer;

public class InsertTrainerAndSubjectClass {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Subject2 sub1=new Subject2();
	sub1.setName("Core Java");
	sub1.setDuration("4 months");
	
	Subject2 sub2=new Subject2();
	sub2.setName("Automation");
	sub2.setDuration("2 months");
	
	Subject2 sub3=new Subject2();
	sub3.setName("SQL");
	sub3.setDuration("3 months");
	
	Trainer t1=new Trainer();
	t1.setName("Harsha");
	t1.setEmail("harshu@gmail.com");

	Trainer t2=new Trainer();
	t2.setName("Collin");
	t2.setEmail("col@gmail.com");
	
	Trainer t3=new Trainer();
	t3.setName("Abhishek");
	t3.setEmail("ak@gmail.com");
	
	t1.setSubjects(List.of(sub1,sub2));
	t2.setSubjects(List.of(sub2,sub3));
	t3.setSubjects(List.of(sub1,sub3));
	
	sub1.setTrainers(List.of(t1,t3));
	sub2.setTrainers(List.of(t1,t2));
	sub3.setTrainers(List.of(t2,t3));
	
	et.begin();
		List.of(sub1,sub2,sub3)
		.stream()
		.forEach(sub->{
			em.persist(sub);
		});
		
		List.of(t1,t2,t3)
		.stream()
		.forEach(t->{
			em.persist(t);
		});
	et.commit();
}
}
