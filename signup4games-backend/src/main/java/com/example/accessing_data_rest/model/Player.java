package com.example.accessing_data_rest.model;

import jakarta.persistence.*;

/**
 * Entity representing a player in a game.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private long uid;

    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Returns the unique identifier of this player.
     *
     * @return the auto‐generated player ID
     */
    public long getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier of this player.
     *
     * @param uid the player ID to set
     */
    public void setUid(long uid) {
        this.uid = uid;
    }

    /**
     * Returns the name of this player.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this player.
     *
     * @param name the player's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the game to which this player belongs.
     *
     * @return the {@link Game} entity this player is in
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the game to which this player belongs.
     *
     * @param game the {@link Game} entity to associate
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Returns the user account for this player.
     *
     * @return the {@link User} who controls this player
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user account for this player.
     *
     * @param user the {@link User} to associate with this player
     */
    public void setUser(User user) {
        this.user = user;
    }
}
