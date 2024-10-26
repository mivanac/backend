package com.ecommerce_fullstack.user.repository;

import com.ecommerce_fullstack.user.entity.User;
import com.ecommerce_fullstack.user.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole userRole);
}
