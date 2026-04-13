package edu.j2ee.spring_security_jwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.j2ee.spring_security_jwt.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
