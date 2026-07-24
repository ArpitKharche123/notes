package edu.springboot_e4.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.springboot_e4.entity.Customer;

@Repository
public interface CustomerRepository
          extends JpaRepository<Customer, Long> {
	
      //Derived Queries
	  public List<Customer> findByNameAndAge(String name, int age);
	  
	  
	  @Query("""
	  		SELECT c
	  		FROM Customer c
	  		ORDER BY c.createdAt DESC
	  		LIMIT 1
	  		""")
	  public Optional<Customer> findLatestCustomer();
	  //findTopByOrderByCreatedAtDesc
	  
	  @Query("""
	  		SELECT c
	  		FROM Customer c
	  		WHERE LOWER(c.name)
	  		LIKE LOWER(CONCAT('%',:keyword,'%'))
	  		""")
	  public List<Customer> searchCustomer(@Param(value = "keyword") String keyword);
	
}
