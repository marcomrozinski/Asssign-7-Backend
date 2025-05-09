package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for user authentication operations.
 * <p>
 * Exposes endpoints for user signup and signin under the path "/api/users".
 * </p>
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Registers a new user account.
     *
     * <p>Accepts a POST request to "/api/users/signup" with a JSON body containing
     * 'name' and 'password'. Returns HTTP 200 OK and the created User object on success,
     * or HTTP 409 Conflict if the username already exists.</p>
     *
     * @param user the User payload from the request body
     * @return ResponseEntity with the created User and status code
     */
    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User createdUser = userService.signUp(user.getName(), user.getPassword());
        return ResponseEntity.ok(createdUser);
    }

    /**
     * Authenticates an existing user.
     *
     * <p>Accepts a POST request to "/api/users/signin" with a JSON body containing
     * 'name' and 'password'. Returns HTTP 200 OK and the User object on successful
     * authentication, or HTTP 401 Unauthorized if credentials are invalid.</p>
     *
     * @param user the User payload from the request body
     * @return ResponseEntity with the authenticated User and status code
     */
    @PostMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        try {
            User loggedInUser = userService.signIn(user.getName(), user.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
