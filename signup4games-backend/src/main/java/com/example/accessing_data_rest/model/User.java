package com.example.accessing_data_rest.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entity representing an application user.
 * Contains basic user information and references to associated players.
 */
@Entity
@Table(name = "user_table") // "user" is a reserved keyword in H2, so we use a different table name
public class User {

    /**
     * Default constructor required for JPA and JSON mapping.
     */
    public User() {
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;

    private String password;

    /**
     * Returns the unique identifier of the user.
     *
     * @return the user ID
     */
    public long getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param uid the user ID to set
     */
    public void setUid(long uid) {
        this.uid = uid;
    }

    /**
     * Returns the username.
     *
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the username.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the list of players associated with this user.
     *
     * @return a list of {@link Player} entities
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the list of players for this user.
     *
     * @param players the list of {@link Player} entities to associate
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Returns the user's password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the user.
     *
     * @return a string containing the user's ID, name, and password
     */
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
