package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Service class responsible for user authentication operations such as signup and signin.
 * <p>
 * Provides methods to register new users and authenticate existing users by verifying credentials.
 * </p>
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Registers a new user with the given username and password.
     *
     * <p>If the username already exists, a {@link ResponseStatusException} with status 409 Conflict
     * is thrown.</p>
     *
     * @param name     the desired username
     * @param password the desired password
     * @return the saved {@link User} instance
     * @throws ResponseStatusException if a user with the same name already exists (HTTP 409)
     */
    public User signUp(String name, String password) {
        List<User> existing = userRepository.findByName(name);
        if (!existing.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        return userRepository.save(user);
    }

    /**
     * Authenticates a user by verifying the provided username and password.
     *
     * <p>If the username is not found or the password does not match, a {@link RuntimeException}
     * is thrown.</p>
     *
     * @param name     the username to authenticate
     * @param password the password to verify
     * @return the authenticated {@link User} instance
     * @throws RuntimeException if the username is not found or the password is incorrect
     */
    public User signIn(String name, String password) {
        List<User> users = userRepository.findByName(name);
        if (users.isEmpty()) {
            throw new RuntimeException("Username not found");
        }

        User user = users.get(0);
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password");
        }

        return user;
    }
}
