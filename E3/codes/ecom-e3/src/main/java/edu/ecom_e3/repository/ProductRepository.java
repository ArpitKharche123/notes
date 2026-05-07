package edu.ecom_e3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.ecom_e3.entity.Product;

@Repository
public interface ProductRepository 
extends JpaRepository<Product, Long> {
	
		public Optional<Product> findByNameAndPrice
		(String name,Double price);
		//Select p from Product p where p.name=:name and p.price=:price
		
		@Query("Select p from Product p ORDER BY p.createdAt DESC LIMIT 1")
		public Product getLatestProduct();
		//findTopByOrderByCreatedAtDesc()
		
		@Query("Select p from Product p "
				+ "where "
				+ "LOWER(p.name) LIKE "
				+ "LOWER(CONCAT('%',:keyword,'%'))")
		public List<Product> searchProductByName(String keyword);
		//findByNameContainingIgnoreCase()
}
