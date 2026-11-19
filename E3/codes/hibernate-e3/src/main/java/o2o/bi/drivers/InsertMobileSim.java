package o2o.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.bi.entities.Mobile;
import o2o.bi.entities.SimCard;

public class InsertMobileSim {
    static void main() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "one_to_one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        Mobile m1 = new Mobile();
        m1.setModel("Redmi note 7");
        m1.setBrand("Redmi");
        m1.setPrice(13_000);

        Mobile m2 = new Mobile();
        m2.setModel("Realme Gt 7");
        m2.setBrand("Realme ");
        m2.setPrice(42_000);

        SimCard s1 = new SimCard();
        s1.setBrand("Jio");
        s1.setNetworkType("5G");

        SimCard s2 = new SimCard();
        s2.setBrand("VI");
        s2.setNetworkType("4G");

        //one to one bi-directional mapping
        m1.setSim(s1);
        s1.setMobile(m1);
        m2.setSim(s2);
        s2.setMobile(m2);

        try{
            et.begin();
                em.persist(m1);
                em.persist(s1);
                em.persist(m2);
                em.persist(s2);
            et.commit();
        }catch (Exception e){
            if (et.isActive())
                et.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
}
