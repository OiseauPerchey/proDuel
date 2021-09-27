package com.example.produel.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            Player ronaldo = new Player("Ronaldo", 95, 94,92,98,41, 71);
            Player messi = new Player("Messi", 94, 96,86,94,44, 87);
            Player mbappe = new Player("Mbappe", 97, 88,80,92,36, 77);
            Player  icardi = new Player("Icardi", 68, 75,70,70,20, 69);
            Player neymar = new Player("Neymar", 91, 83,86,94,37, 63);
            Player ramos = new Player("Ramos", 70, 70,76,74,99, 99);
            Player hakimi = new Player("Hakimi", 95, 92,95,99,30, 94);
            Player son = new Player("Son", 88, 87,82,86,43, 69);
            Player kroos = new Player("Kroos", 79, 68,86,59,78, 89);
            Player marquinhos = new Player("Marquinhos", 81, 53,75,74,89, 81);

            repository.saveAll(
                    List.of(ronaldo, messi, mbappe, icardi, neymar, ramos, hakimi, son, kroos, marquinhos)
            );
        };

    }

}