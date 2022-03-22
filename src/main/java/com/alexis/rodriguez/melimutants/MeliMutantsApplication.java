package com.alexis.rodriguez.melimutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableJpaAuditing
public class MeliMutantsApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(MeliMutantsApplication.class);

	public static void main(String[] args) {
		logger.info("****************** Iniciando aplicacion de consulta DNA Mutante ******************");
		SpringApplication.run(MeliMutantsApplication.class, args);
	}

}
