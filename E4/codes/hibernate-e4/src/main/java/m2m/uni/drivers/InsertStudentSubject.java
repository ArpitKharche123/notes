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
		 EntityManagerFactory emf =
		Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Student s1= new Student();
		s1.setName("Ritvik");
		s1.setAge(12);
		s1.setSec('A');
		
		Student s2= new Student();
		s2.setName("Vikas");
		s2.setAge(13);
		s2.setSec('B');
		
		Subject sub1=new Subject();
		sub1.setName("Maths");
		sub1.setCredits(3);
		
		Subject sub2=new Subject();
		sub2.setName("Physics");
		sub2.setCredits(4);
		
		List<Subject> subjects = Arrays.asList(sub1,sub2);
		
		s1.setSubjects(subjects);
		s2.setSubjects(subjects);
		
		et.begin();
			for(Subject s:subjects) {
				em.persist(s);
			}
			em.persist(s1);
			em.persist(s2);
		et.commit();
	}
}
