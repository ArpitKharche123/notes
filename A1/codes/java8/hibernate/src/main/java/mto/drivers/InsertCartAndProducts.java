package mto.drivers;

import java.beans.PersistenceDelegate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import mto.entities.Cart;
import mto.entities.Product;

public class InsertCartAndProducts {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("many_to_one");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Cart cart=new Cart();
		cart.setType("food-cart");
		
		Product p1=new Product();
		p1.setName("VadaPav");
		p1.setPrice(10);
		p1.setQuantity(5);
		p1.setCart(cart);
		
		Product p2=new Product();
		p2.setName("Biryani");
		p2.setPrice(300);
		p2.setQuantity(2);
		p2.setCart(cart);
		
		et.begin();
			em.persist(cart);
			em.persist(p1);
			em.persist(p2);
		et.commit();
	}
}
