package m2m.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Student;

public class FetchStudentSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		
		em.createQuery("Select s from Student s "
				+ "join fetch s.subjects",Student.class)
		  .getResultList()
		  .forEach(s -> {
			  System.out.println("Student Name: "+s.getName());
			  System.out.println("Subjects:  ");
			  s.getSubjects()
			   .forEach(sub->{
				   System.out.println(sub.getName());
			   });
			  System.out.println("----------------------------");
		  } );
	}
}
