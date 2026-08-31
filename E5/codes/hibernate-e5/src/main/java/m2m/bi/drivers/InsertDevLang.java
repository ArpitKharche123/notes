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
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_many");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Developer dev1 = new Developer();
		dev1.setName("Joe");
		dev1.setExp(2);
		dev1.setRole("ASE");
		
		Developer dev2 = new Developer();
		dev2.setName("Mark");
		dev2.setExp(3);
		dev2.setRole("SSE");
		
		Language l1 = new Language();
		l1.setName("Java");
		l1.setVersion(25);
		
		Language l2 = new Language();
		l2.setName("Python");
		l2.setVersion(20);
		
		//many to many bi directional mapping
		List<Developer> developers = Arrays.asList(dev1,dev2);
		List<Language> languages = Arrays.asList(l1,l2);
		
		developers.forEach(d -> d.setLanguages(languages));
		languages.forEach(l -> l.setDevelopers(developers));
		
		
		et.begin();
			developers.forEach(d -> em.persist(d));
			languages.forEach(l -> em.persist(l));
		et.commit();
	}
}
