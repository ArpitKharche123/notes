package edu.j2ee.spring_security_jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.j2ee.spring_security_jwt.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
