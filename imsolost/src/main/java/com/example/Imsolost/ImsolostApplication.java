package com.example.Imsolost;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Imsolost.domain.Oppilas;
import com.example.Imsolost.domain.OppilasRepo;


@SpringBootApplication
public class ImsolostApplication {
	private static final Logger log = LoggerFactory.getLogger(ImsolostApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ImsolostApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner ImsolostApp(OppilasRepo repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Oppilas("Eero", "Salomies", "eero@ict-software.fi"));
			repository.save(new Oppilas("Erkki", "Testinimi", "fullyqualified@domain.name"));	
			
			log.info("Haetaan kaikki oppilaat");
			for (Oppilas oppilas : repository.findAll()) {
				log.info(oppilas.toString());
			}
		};
	}
		
}
