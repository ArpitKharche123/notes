package m2m.uni.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Student2;
import m2m.uni.entities.Subject;

public class InsertStudentsAndSubjects {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Subject s1=new Subject();
		s1.setName("Core Java");
		s1.setCredits(4);
		
		Subject s2=new Subject();
		s2.setName("Python");
		s2.setCredits(3);
		
		Subject s3=new Subject();
		s3.setName("SQL");
		s3.setCredits(2);
		
		Student2 st1=new Student2();
		st1.setName("Payal");
		st1.setMobile(9822735463l);
		st1.setGender("female");
		
		Student2 st2=new Student2();
		st2.setName("Adesh");
		st2.setMobile(9822345463l);
		st2.setGender("male");
		
		Student2 st3=new Student2();
		st3.setName("Sam");
		st3.setMobile(8827773649l);
		st3.setGender("male");
		
		st1.setSubjects(List.of(s1,s3));
		st2.setSubjects(List.of(s1,s2));
		st3.setSubjects(List.of(s2,s3));
		
		et.begin();
			List<Subject> subs 
			= List.of(s1,s2,s3);
			subs
			.stream()
			.forEach(sub -> em.persist(sub));
			
			List<Student2> studs 
			= List.of(st1,st2,st3);
			
			for(Student2 s:studs) {
				em.persist(s);
			}
		et.commit();
	}
}
