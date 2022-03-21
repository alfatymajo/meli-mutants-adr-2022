package com.alexis.rodriguez.melimutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MeliMutantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeliMutantsApplication.class, args);
	}

}
