package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(String name, String password) {
        List<User> existing = userRepository.findByName(name);
        if (!existing.isEmpty()) {
            throw new RuntimeException("Brugernavn allerede i brug");
        }

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User signIn(String name, String password) {
        List<User> users = userRepository.findByName(name);
        if (users.isEmpty()) {
            throw new RuntimeException("Brugernavn ikke fundet");
        }

        User user = users.get(0);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Forkert adgangskode");
        }

        return user;
    }

}
