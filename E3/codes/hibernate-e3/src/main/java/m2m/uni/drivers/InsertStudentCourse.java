package m2m.uni.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.uni.entities.Course;
import m2m.uni.entities.Student;

public class InsertStudentCourse {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_many");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Student s1=new Student();
		s1.setName("Sarthak");
		s1.setEmail("sarkthak@gmail.com");
		s1.setGender("Male");
		s1.setPhone(9020973645l);
		
		Student s2=new Student();
		s2.setName("Sangram");
		s2.setEmail("sangram@gmail.com");
		s2.setGender("Male");
		s2.setPhone(9027873645l);
		
		Student s3=new Student();
		s3.setName("Maruti");
		s3.setEmail("maruti@gmail.com");
		s3.setGender("Male");
		s3.setPhone(9020973895l);
		
		Course c1=new Course();
		c1.setName("Java Full Stack");
		c1.setFees(35000);
		c1.setDurationInMonths(6);
		
		Course c2=new Course();
		c2.setName("Python Full Stack");
		c2.setFees(25000);
		c2.setDurationInMonths(4);
		
		Course c3=new Course();
		c3.setName("Testing");
		c3.setFees(30000);
		c3.setDurationInMonths(5);
		
		s1.setCourses(List.of(c1,c2,c3));
		s2.setCourses(List.of(c2,c3));
		s3.setCourses(List.of(c3));
		
		et.begin();
			List<Student> studs = List.of(s1,s2,s3);
			for(Student s:studs) {
				em.persist(s);
			}
			List.of(c1,c2,c3).forEach(c-> em.persist(c));
		et.commit();
	}
}
