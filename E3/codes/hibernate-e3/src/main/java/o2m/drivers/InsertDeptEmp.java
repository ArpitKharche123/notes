package o2m.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import o2m.entities.Department;
import o2m.entities.Employee;

import java.util.List;

public class InsertDeptEmp {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "one_to_many");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Department d1 = new Department();
        d1.setName("Development");

        Department d2 = new Department();
        d2.setName("Testing");

        Employee e1 = new Employee();
        e1.setName("John");
        e1.setMobile(9877226354l);
        e1.setEmail("john@gmail.com");

        Employee e2 = new Employee();
        e2.setName("Mark");
        e2.setMobile(9877426354l);
        e2.setEmail("mk@gmail.com");

        Employee e3 = new Employee();
        e3.setName("Bob");
        e3.setMobile(9347226354l);
        e3.setEmail("Bob@gmail.com");

        Employee e4 = new Employee();
        e4.setName("Carl");
        e4.setMobile(9877246354l);
        e4.setEmail("carl@gmail.com");

        List<Employee> developers = List.of(e1, e2);
        List<Employee> testers = List.of(e3, e4);

        //one to many uni-directional mapping
        d1.setEmployees(developers);
        d2.setEmployees(testers);

        try{
            et.begin();
                em.persist(d1);
                em.persist(d2);
                developers.forEach(em::persist);
                testers.forEach(
                        e-> em.persist(e)
                );
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
