package drivers;

import entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RemoveStudent {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("demo");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		//Fetching the student record to be deleted
		Student student = em.find(Student.class, 1);
		if (student!=null) {
			em.remove(student);
			System.out.println("Student deleted successfully");
		}else {
			System.err.println("Student does not exists");
		}
		et.commit();
	}
}
