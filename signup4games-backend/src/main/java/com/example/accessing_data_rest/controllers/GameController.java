package com.example.accessing_data_rest.controllers;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games") // Endpoint for spiloprettelse
public class GameController {

    @Autowired
    private GameService gameService; // Autowired GameService

    // Opret et nyt spil
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        try {
            Game createdGame = gameService.createGame(game);  // Opretter spillet via GameService
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGame);  // Returnerer 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Returnerer 500 Internal Server Error
        }
    }
}
