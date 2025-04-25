package com.example.accessing_data_rest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="user_table") // this is important! "user" is a keyword in H2 and not an identifier
public class User {
    public User() {
        // default constructor needed for JSON mapping
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long uid;

    private String name;

    // TODO this class needs to be extended with references to Player and
    //      the other way round (similar to the reference from Game to Player
    //      and the other way round.

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
