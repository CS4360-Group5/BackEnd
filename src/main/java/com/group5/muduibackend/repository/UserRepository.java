package com.group5.muduibackend.repository;

import com.group5.muduibackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that Spring Boot uses to interact with repository
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
