package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.User;
import com.example.accessing_data_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        System.out.println("Received user name: " + user.getName());  // Debugging: Udskriv userens name
        User createdUser = userService.signUp(user.getName(), user.getPassword());
        System.out.println("Created User: " + createdUser);  // Sørg for at denne linje udskriver det rigtige objekt

        // Returner brugeren med UID, name og password korrekt
        return ResponseEntity.ok(createdUser);
    }


    @PostMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        try {
            User loggedInUser = userService.signIn(user.getName(), user.getPassword());
            return ResponseEntity.ok(loggedInUser);
        } catch (RuntimeException e) {
            // Hvis login fejler, returner 401 i stedet for 500
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);  // 401 Unauthorized
        }
    }
}
