package m2o.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import m2o.entities.Hospital;
import m2o.entities.Patient;

public class FetchPatientHospital {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "many_to_one");
        EntityManager em = emf.createEntityManager();

        em.createQuery("FROM Patient p", Patient.class)
        .getResultList()
                .forEach(
                        patient -> {
                            Hospital hospital = patient.getHospital();
                            System.out.printf("""
                                    Patient Name: %s
                                    Age: %d
                                    Weight: %.2f
                                          Hospital name: %s
                                          Type: %s
                                          Location: %s
                                      -----------------------
                                    """
                            ,patient.getName(),patient.getAge(),patient.getWeight(),
                                    hospital.getName(),hospital.getType(),
                                    hospital.getLocation());
                        }
                );

    }
}
