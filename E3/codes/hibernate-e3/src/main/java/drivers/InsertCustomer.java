package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertCustomer {
    static void main() {
        EntityManagerFactory emf
        = Persistence.createEntityManagerFactory(
          "hibernate");

        EntityManager em = emf.createEntityManager();
        //DML operations
        EntityTransaction et = em.getTransaction();

        Customer c1 = new Customer();
        c1.setName("Mark");
        c1.setAge(56);
        c1.setEmail("mk@gmail.com");

        Customer c2 = new Customer();
        c2.setName("Henry");
        c2.setAge(16);
        c2.setEmail("henry@gmail.com");

        Customer c3 = new Customer();
        c3.setName("Tom");
        c3.setAge(34);
        c3.setEmail("tom@gmail.com");

        try{
            et.begin();

            em.persist(c1);
            em.persist(c2);
            em.persist(c3);

            et.commit();
        }catch (Exception e){
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
