package com.example.proplayer.player;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {

        this.playerRepository = playerRepository;
    }


    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findPlayerByName(player.getPlayer_name());
        if (playerOptional.isPresent()) {
            throw new IllegalStateException("player already exists");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("player with id " + playerId + " does not exists");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(Long playerId, String name, Integer pac, Integer sho, Integer pas, Integer dri, Integer def, Integer phy) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new IllegalStateException("player with id " + playerId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(player.getPlayer_name(), name)) {
            player.setPlayer_name(name);
        }

        if (pac != null && pac > 0 && pac < 100) {
            player.setPlayer_pac(pac);
        }

        if (sho != null && sho > 0 && sho < 100) {
            player.setPlayer_sho(sho);
        }

        if (pas != null && pas > 0 && pas < 100) {
            player.setPlayer_pas(pas);
        }

        if (dri != null && dri > 0 && dri < 100) {
            player.setPlayer_dri(dri);
        }

        if (def != null && def > 0 && def < 100) {
            player.setPlayer_def(def);
        }

        if (phy != null && phy > 0 && phy < 100) {
            player.setPlayer_phy(phy);
        }
    }

    public String proDuel(Long attId, Long defId) {

        Player player1 = playerRepository.findById(attId).orElseThrow(() -> new ResourceNotFoundException("id: " + attId + "not available"));
        Player player2 = playerRepository.findById(defId).orElseThrow(() -> new ResourceNotFoundException("id: " + defId + "not available"));
        if (player1.getPlayer_score() > player2.getPlayer_score() + 3)
            return "Winner of the duel is " + player1.getPlayer_name();
        if (player1.getPlayer_score() <= player2.getPlayer_score() + 3 && player1.getPlayer_score() >= player2.getPlayer_score() - 3)
            return "cannot determine winner between " + player1.getPlayer_name() + " and " + player2.getPlayer_name();
        else
            return "Winner of the duel is " + player2.getPlayer_name();
    }
}
