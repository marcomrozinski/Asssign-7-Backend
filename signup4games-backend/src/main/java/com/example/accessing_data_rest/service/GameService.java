package com.example.accessing_data_rest.service;

import com.example.accessing_data_rest.model.Game;
import com.example.accessing_data_rest.model.Player;
import com.example.accessing_data_rest.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling business logic related to {@link Game} entities.
 * <p>
 * Provides operations for creating games and managing their associated players.
 * </p>
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    /**
     * Creates a new game and automatically adds a "creator" player to it.
     * <p>
     * When a game is created, this method instantiates a new {@link Player} with the
     * name "Creator of &lt;gameName&gt;", associates it with the provided {@link Game},
     * and then persists the game (including its players) to the database.
     * </p>
     *
     * @param game the {@link Game} object containing the game's configuration
     *             (name, minimum and maximum players, etc.)
     * @return the persisted {@link Game} instance, including its generated ID
     *         and the newly created creator player
     */
    public Game createGame(Game game) {

        Player creator = new Player();
        creator.setName("Creator of " + game.getName());

        game.getPlayers().add(creator);

        return gameRepository.save(game);
    }
}
