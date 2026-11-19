package o2o.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.uni.entities.Car;
import o2o.uni.entities.Engine;

public class EngineTransfer {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "one_to_one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            Car car1 = em.find(Car.class, 1);
            //Fetching engine associated with car1
            Engine engine = car1.getEngine();

            //breaking one-to-one mapping
            car1.setEngine(null);
            Car car2 = em.find(Car.class, 2);
            car2.setEngine(engine);
            et.commit();
        } catch (Exception e) {
            if(et.isActive()){
                et.rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }

    }
}
