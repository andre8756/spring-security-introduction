package com.security.demo.Repository;

import com.security.demo.Entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomUser, Long> {

    Optional<CustomUser> findByUsername(String username);
}
