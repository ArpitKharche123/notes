package o2o.bi.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.bi.entities.Mobile;

public class TestCascading {
    static void main() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "one_to_one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        Mobile mobile = em.find(Mobile.class, 1);

        try{
            et.begin();
                em.remove(mobile);
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
