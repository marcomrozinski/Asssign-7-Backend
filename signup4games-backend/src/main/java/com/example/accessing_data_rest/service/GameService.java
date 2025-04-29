package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.model.Player;
import com.example.accessing_data_rest.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game createGame(Game game) {
        // Tilføj den første spiller (den bruger, der opretter spillet)
        Player creator = new Player();
        // Sæt den spiller som ejer af spillet
        creator.setName("Creator of " + game.getName());

        // Tilføj spiller til spillet
        game.getPlayers().add(creator);

        // Gem spillet i databasen
        return gameRepository.save(game);  // Gemmer spillet i databasen
    }
}
