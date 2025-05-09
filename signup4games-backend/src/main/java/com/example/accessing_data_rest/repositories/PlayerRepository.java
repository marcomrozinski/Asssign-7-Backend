package com.example.accessing_data_rest.repositories;

import com.example.accessing_data_rest.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "player", path = "player")
public interface PlayerRepository extends CrudRepository<Player, Long> {
}

