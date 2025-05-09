package com.example.accessing_data_rest.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * En entitet der repræsenterer et spil med dets konfiguration og tilmeldte spillere.
 */
@Entity
public class Game {

    @Id
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    private int minPlayers;

    private int maxPlayers;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    /**
     * Henter spillets unikke id.
     *
     * @return id for spillet
     */
    public long getUid() {
        return uid;
    }

    /**
     * Angiver spillets id.
     *
     * @param uid det nye id for spillet
     */
    public void setUid(long uid) {
        this.uid = uid;
    }

    /**
     * Henter spillets navn.
     *
     * @return navnet på spillet
     */
    public String getName() {
        return name;
    }

    /**
     * Angiver spillets navn.
     *
     * @param name det ønskede navn for spillet
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Henter minimum antal spillere, der kan deltage.
     *
     * @return minimum antal spillere
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Angiver minimum antal spillere, der kan deltage.
     *
     * @param minPlayers minimum antal spillere
     */
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * Henter maksimum antal spillere, der kan deltage.
     *
     * @return maksimum antal spillere
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Angiver maksimum antal spillere, der kan deltage.
     *
     * @param maxPlayers maksimum antal spillere
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Henter listen af spillere, der er tilmeldt spillet.
     *
     * @return liste af {@link Player}
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Angiver listen af spillere for spillet.
     *
     * @param players liste af {@link Player}
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     * Henter den bruger, der ejer eller oprettede spillet.
     *
     * @return {@link User} der ejer spillet
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Angiver den bruger, der ejer eller opretter spillet.
     *
     * @param owner {@link User} der skal være ejer af spillet
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
