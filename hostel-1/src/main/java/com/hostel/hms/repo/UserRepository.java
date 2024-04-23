package com.hostel.hms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hostel.hms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}