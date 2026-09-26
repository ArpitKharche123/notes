package edu.learningspringboot.repository;

import edu.learningspringboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByNameAndCategory(String name, String category);

    @Query("""
            SELECT p 
            FROM Product p
            WHERE LOWER(p.name) 
            LIKE  LOWER(CONCAT('%',:keyword,'%'))   
            OR 
            LOWER(p.category) 
            LIKE  LOWER(CONCAT('%',:keyword,'%'))
            """)
    List<Product> searchProduct(@Param(value = "keyword")String keyword);
    //or
    //findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase

    @Query("""
        SELECT p 
        FROM Product p
        ORDER BY p.createdAt 
        DESC LIMIT 1
        """)
    Optional<Product> getLatestProduct();
    //findByTopByCreatedAtDesc



}
