package mto.drivers;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchProductsAndcart {
	public static void main(String[] args) {
		EntityManagerFactory emf=
		Persistence.createEntityManagerFactory("many_to_one");
		EntityManager em=emf.createEntityManager();
		
		List products =
		em.createQuery(
		"Select p from Product p")
		 .getResultList();
		if (!products.isEmpty()) {
			products.stream()
			.forEach(System.out::println);
		}else {
			System.err.println("Products not found");
		}
		
	}
}
