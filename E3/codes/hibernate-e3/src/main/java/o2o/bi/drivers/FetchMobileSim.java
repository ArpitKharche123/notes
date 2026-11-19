package o2o.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2o.bi.entities.Mobile;
import o2o.bi.entities.SimCard;

public class FetchMobileSim {
    static void main() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "one_to_one");
        EntityManager em = emf.createEntityManager();

        em.createQuery("select m from Mobile m", Mobile.class)
                .getResultList()
                .forEach(
                        mobile -> {
                            System.out.println("Mobile details:");
                            SimCard sim = mobile.getSim();
                            System.out.printf("""
                                            Model: %s
                                            Brand: %s
                                            Sim: %s
                                            Network: %s
                                            -------------------------
                                            """,
                                    mobile.getModel(), mobile.getBrand()
                                    , sim.getBrand(), sim.getNetworkType());
                        }
                )
        ;
    }
}
