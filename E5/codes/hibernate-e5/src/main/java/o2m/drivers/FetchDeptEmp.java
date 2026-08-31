package o2m.drivers;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import o2m.entities.Department;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

public class FetchDeptEmp {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("one_to_many");
        EntityManager em = emf.createEntityManager();

        // n + 1 query problem will occur in below qurey
        //em.createQuery("Select d from Department d",Department.class)

        //FIX: Using join fetch
        em.createQuery("Select d from Department d join fetch d.employees"
                        , Department.class)
                .getResultList()
                .forEach(d -> {
                    System.out.println("Department: " + d.getName());
                    System.out.println("Employees: ");
                    d.getEmployees()
                            .forEach(e -> {
                                System.out.println(e.getName());
                            });
                    System.out.println("-----------------------");
                });
    }
}