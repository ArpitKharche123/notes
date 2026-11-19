package o2o.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2o.uni.entities.Car;
import o2o.uni.entities.Engine;

public class InsertCarEngine {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                        "one_to_one");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Car car1= new Car();
        car1.setModel("Fortuner");
        car1.setBrand("Toyota");
        car1.setColor("Black");
        car1.setPrice(45_00_000);

        Car car2= new Car();
        car2.setModel("XUV");
        car2.setBrand("Mahindra");
        car2.setColor("White");
        car2.setPrice(15_00_000);

        Engine engine = new Engine();
        engine.setCc(800);
        engine.setType("Petrol");

        //One to One mapping
        car1.setEngine(engine);

        try{
            et.begin();
                em.persist(car1);
                em.persist(car2);
                em.persist(engine);
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
