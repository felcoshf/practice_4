package com.example.flc.repository;

import com.example.flc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);

    User findByEmail(String email);

    User findByName(String name);

    List<User> findAllByName(String name);

}