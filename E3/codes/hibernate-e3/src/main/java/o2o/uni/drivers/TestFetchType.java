package o2o.uni.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2o.uni.entities.Car;

public class TestFetchType {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "one_to_one");
        EntityManager em = emf.createEntityManager();

        Car car = em.find(Car.class, 2);
        System.out.println(car);
        /*
            EAGER: applies left join with the Engine
            LAZY: Only  Car is fetched
            if toString() is overridden
            Car and Engine will be fetched separately!
         */
    }
}
