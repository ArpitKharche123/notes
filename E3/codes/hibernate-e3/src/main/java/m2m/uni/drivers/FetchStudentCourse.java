package m2m.uni.drivers;

import java.rmi.StubNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Student;

public class FetchStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_many");
		
		EntityManager em=emf.createEntityManager();
		
		em.createQuery("Select s from Student s join fetch s.courses"
				,Student.class)
		.getResultList()
		.forEach(s->{
			System.out.println("Student: "+s.getName()+"\nCourses:");
			s.getCourses()
			 .forEach(c->{
				 System.out.println(c.getName());
			 });
			System.out.println("-------------------------------");
		});
	}
}
