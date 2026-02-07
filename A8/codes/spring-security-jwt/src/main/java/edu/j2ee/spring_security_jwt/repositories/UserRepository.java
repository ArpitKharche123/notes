package edu.j2ee.spring_security_jwt.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.j2ee.spring_security_jwt.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

