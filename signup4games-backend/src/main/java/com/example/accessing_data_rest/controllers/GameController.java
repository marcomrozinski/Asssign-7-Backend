package com.example.accessing_data_rest.controllers;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Game entities.
 * Exposes endpoints under "/api/games".
 */
@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * Creates a new game.
     *
     * <p>Accepts a POST request with a Game object in the request body,
     * persists it using the GameService, and returns the saved instance.</p>
     *
     * @param game the game details to create
     * @return ResponseEntity containing the created Game and HTTP status:
     *         <ul>
     *           <li>201 Created, if the game was successfully created;</li>
     *           <li>500 Internal Server Error, if an unexpected error occurred.</li>
     *         </ul>
     */
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        try {
            Game createdGame = gameService.createGame(game);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdGame);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
