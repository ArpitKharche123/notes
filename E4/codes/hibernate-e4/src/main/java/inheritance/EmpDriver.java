package inheritance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmpDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("hibernate");
			
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			
			PartTimeEmployee p= new PartTimeEmployee();
			p.setName("Jack");
			p.setAge(28);
			p.setHours(6);
			p.setMonths(6);
			p.setPay(60_000);
			
			FullTimeEmployee f= new FullTimeEmployee();
			f.setName("Michael");
			f.setAge(56);
			f.setExp(8);
			f.setSalary(10_00_000);
			
			et.begin();
				em.persist(p);
				em.persist(f);
			et.commit();
	}
}
