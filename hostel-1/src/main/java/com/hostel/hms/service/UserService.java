package com.hostel.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.hms.model.User;
import com.hostel.hms.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void signup(User user) {
        userRepository.save(user);
    }

    public boolean login(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false; 
        }
    }

    public boolean resetPassword(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            existingUser.setPassword(user.getPassword());
            existingUser.setConfirmpassword(user.getPassword());
            userRepository.save(existingUser);
            return true;
        } else {
            return false;
        }
    }
}

