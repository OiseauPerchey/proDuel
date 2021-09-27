package com.example.produel.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    public void registerNewPlayer(@RequestBody Player player) {
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path="{playerId}")
    public void deletePlayer(@PathVariable("playerId") Long playerId) {
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path="{playerId}")
    public void updatePlayer(
            @PathVariable("playerId") Long playerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer pac,
            @RequestParam(required = false) Integer sho,
            @RequestParam(required = false) Integer pas,
            @RequestParam(required = false) Integer dri,
            @RequestParam(required = false) Integer def,
            @RequestParam(required = false) Integer phy) {
        playerService.updatePlayer(playerId, name, pac, sho, pas, dri, def, phy);
    }

    @GetMapping(path="/duel/{playerAtt}/{playerDef}")
    public String proDuel(@PathVariable("playerAtt") Long playerAtt, @PathVariable("playerDef") Long playerDef) {

        return playerService.proDuel(playerAtt, playerDef);
    }

}
