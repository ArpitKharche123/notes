package o2o.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.bi.entities.Mobile;

public class TestOrphanRemoval {
    static void main() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "one_to_one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();

            Mobile mobile = em.find(Mobile.class, 2);

            mobile.setSim(null);

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
