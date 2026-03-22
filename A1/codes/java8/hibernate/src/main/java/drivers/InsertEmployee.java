package drivers;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("demo");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			Employee e=new Employee();
			e.setName("Ganesh");
			
			em.persist(e);
		et.commit();
	}
}
