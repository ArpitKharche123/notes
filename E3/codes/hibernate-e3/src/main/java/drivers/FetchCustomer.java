package drivers;

import entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class FetchCustomer {
    static void main() {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory(
                "hibernate");
        EntityManager em = emf.createEntityManager();

        Customer c1 = em.find(Customer.class, 1);
        if (c1!=null){
            System.out.println(c1.getName());
        }

        //fetch all customers
        List<Customer> customers
                = em.createQuery(
                        "select c from Customer c"
                        , Customer.class)
                .getResultList();

        customers.forEach(c->{
            System.out.printf("""
                    Id: %d
                    Name: %s
                    Age: %d
                    Email: %s
                    --------------
                    """,
                    c.getId(),c.getName(),c.getAge(),c.getEmail()
            );
        });
    }
}
