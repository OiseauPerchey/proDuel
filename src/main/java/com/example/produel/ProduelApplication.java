package com.example.produel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProduelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProduelApplication.class, args);
	}

}
