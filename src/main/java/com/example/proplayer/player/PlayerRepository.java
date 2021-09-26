package com.example.proplayer.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.player_name = ?1")
    Optional<Player> findPlayerByName(String player_name);

    @Query("SELECT p from Player p WHERE p.player_id = ?1")
    Optional<Player> findPlayerById(String player_id);

}
