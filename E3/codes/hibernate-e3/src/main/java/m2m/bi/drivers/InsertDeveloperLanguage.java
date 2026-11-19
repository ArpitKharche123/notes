package m2m.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2m.bi.entities.Developer;
import m2m.bi.entities.Language;

import java.util.List;

public class InsertDeveloperLanguage {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "many_to_many");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Developer d1 = new Developer();
        d1.setName("Jack");
        d1.setRole("SDE");
        d1.setExp(4);

        Developer d2 = new Developer();
        d2.setName("Bob");
        d2.setRole("FD");
        d2.setExp(2);

        Language l1 = new Language();
        l1.setName("Java");
        l1.setType("HLL");
        l1.setVersion(25.1);

        Language l2 = new Language();
        l2.setName("Python");
        l2.setType("HLL");
        l2.setVersion(12.1);

        //many to many  bidirectional mapping

        List<Language> langs = List.of(l1, l2);
        List<Developer> devs = List.of(d1, d2);

        d1.setLanguages(langs);
        d2.setLanguages(langs);

        l1.setDevelopers(devs);
        l2.setDevelopers(devs);

        try{
            et.begin();
                langs.forEach(em::persist);
                devs.forEach(em::persist);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
