package m2o.drivers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import m2o.entities.Cart;
import m2o.entities.Product;

public class InsertProductAndCart {
	public static void main(String[] args) {
		EntityManagerFactory emf
		= Persistence.createEntityManagerFactory("many_to_one");
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		Product p1=new Product();
		p1.setName("TV");
		p1.setPrice(30000);
		p1.setQuantity(200);
		
		Product p2=new Product();
		p2.setName("Laptop");
		p2.setPrice(70000);
		p2.setQuantity(100);
		
		Cart cart=new Cart();
		cart.setType("normal");
		
		p1.setCart(cart);
		p2.setCart(cart);
		
		et.begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(cart);
		et.commit();
	}
}
