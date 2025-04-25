package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(String name, String password) {
        List<User> existing = userRepository.findByName(name);
        if (!existing.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        // Check if the user is saved correctly
        System.out.println("User to be saved: " + user);  // Debugging line

        return userRepository.save(user);  // Sørg for at returnere den korrekt gemte bruger
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
