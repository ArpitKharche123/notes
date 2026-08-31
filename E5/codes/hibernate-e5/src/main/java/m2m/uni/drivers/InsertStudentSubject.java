package m2m.uni.drivers;

import java.util.Arrays; 
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Student;
import m2m.uni.entities.Subject;

public class InsertStudentSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setName("Anuj");
		s1.setAge(23);
		s1.setSection('A');
		
		Student s2 = new Student();
		s2.setName("Bharti");
		s2.setAge(24);
		s2.setSection('B');
		
		Subject sub1 = new Subject();
		sub1.setName("EP");
		sub1.setCredits(4);
		sub1.setTotalMarks(100);
		
		Subject sub2 = new Subject();
		sub2.setName("Agile");
		sub2.setCredits(3);
		sub2.setTotalMarks(50);
		
		List<Subject> subjects = Arrays.asList(sub1,sub2);
		
		//many to many uni directional mapping
		s1.setSubjects(subjects);
		s2.setSubjects(subjects);
		
		et.begin();
			em.persist(s1);
			em.persist(s2);
			subjects.forEach(sub -> em.persist(sub));
		et.commit();
	}
}
