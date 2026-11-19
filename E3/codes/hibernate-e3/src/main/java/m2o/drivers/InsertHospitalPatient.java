package m2o.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2o.entities.Hospital;
import m2o.entities.Patient;

public class InsertHospitalPatient {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "many_to_one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Patient p1 = new Patient();
        p1.setName("Darsh");
        p1.setAge(21);
        p1.setWeight(67.9);

        Patient p2 = new Patient();
        p2.setName("Vikas");
        p2.setAge(41);
        p2.setWeight(87.9);

        Hospital h1 = new Hospital();
        h1.setName("Mamta");
        h1.setType("Maternity");
        h1.setLocation("Wakad");

        //many to one mapping
        p1.setHospital(h1);
        p2.setHospital(h1);

        try{
            et.begin();
                em.persist(h1);
                em.persist(p1);
                em.persist(p2);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) et.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
