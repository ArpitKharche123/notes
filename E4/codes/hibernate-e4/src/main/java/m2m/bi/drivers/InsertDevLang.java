package m2m.bi.drivers;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.bi.entities.Developer;
import m2m.bi.entities.Language;

public class InsertDevLang {
	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
				
		Developer d1= new Developer();
		d1.setName("John");
		d1.setRole("Trainee");
		d1.setExp(1);
		
		Developer d2= new Developer();
		d2.setName("Carl");
		d2.setRole("ASE");
		d2.setExp(1.5);
		
		Language l1=new Language();
		l1.setName("Java");
		l1.setVersion("JDK26");
		
		Language l2=new Language();
		l2.setName("Python");
		l2.setVersion("8.0");
		
		List<Developer> devs = Arrays.asList(d1,d2);
		List<Language> langs = Arrays.asList(l1,l2);
		
		d1.setLanguages(langs);
		d2.setLanguages(langs);
		
		l1.setDevelopers(devs);
		l2.setDevelopers(devs);
		
		et.begin();
			
			for(Developer d: devs) {
				em.persist(d);
			}
			langs.forEach(l -> em.persist(l));
		et.commit();
				
	}
}
