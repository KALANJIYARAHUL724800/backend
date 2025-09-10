package com.example.portfolio_backend.repository;

import com.example.portfolio_backend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUsernameAndPassword(String username, String password);
}
