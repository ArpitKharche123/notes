package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RemoveCustomer {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "hibernate");
        EntityManager em = emf.createEntityManager();
        //DML operations
        EntityTransaction et = em.getTransaction();

        //Fetching the customer to be removed
        Customer c1 = em.find(Customer.class, 3);
        try{
            if(c1!=null){
                et.begin();
                em.remove(c1);
                et.commit();
            }else {
                System.err.println("Customer not found!");
            }
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
