package com.akshay.repositories;

import com.akshay.entities.User;
import com.akshay.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    User findByRole(UserRole userRole);

    Optional<User> findFirstByEmail(String email);
}

