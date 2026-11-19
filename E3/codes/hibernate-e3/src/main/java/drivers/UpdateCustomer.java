package drivers;

import entities.Customer;
import jakarta.persistence.*;

public class UpdateCustomer {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "hibernate");
        EntityManager em = emf.createEntityManager();
        //DML operations
        EntityTransaction et = em.getTransaction();

        //Fetching the customer to be updated
        Customer c1 = em.find(Customer.class, 3);

        //Dynamic JPQL to update Customer
        Query query
                = em.createQuery("""
                        UPDATE Customer c
                        SET c.age= ?1 
                        WHERE c.email = :email
                        """)
                //Setting value for positional parameter(?1)
                .setParameter(1, 21)
                //Setting value for named parameter(:email)
                .setParameter("email", "mk@gmail.com");

        try{
            et.begin();
           if(c1!=null){
                //updating the age
//               c1.setAge(19);
           }else {
               System.err.println("Customer not found!");
           }
           //Executing dynamic jpql
            query.executeUpdate();
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
