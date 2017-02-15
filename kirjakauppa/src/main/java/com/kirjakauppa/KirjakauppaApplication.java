package com.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kirjakauppa.domain.Kirja;
import com.kirjakauppa.domain.KirjaRepository;
import com.kirjakauppa.domain.Kayttaja;
import com.kirjakauppa.domain.KayttajaRepository;



@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(KirjaRepository repository, KayttajaRepository urepository) {
		return (args) -> {
			log.info("Lisätään hyviä esimerkki kirjoja");
			repository.save(new Kirja("Kissa muurin yli", "Stanislav Lem", "1985", "123123123-2", "40€"));
			repository.save(new Kirja("Säätiö: Toinen säätiö", "Isaac Asimov", "1953", "214234232-9", "80€"));	
			
			log.info("Lisätään käyttäjät in-memory tietokantaan.");
			Kayttaja user1 = new Kayttaja("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Kayttaja user2 = new Kayttaja("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			 
			 
			log.info("haetaan kaikki kirjat");
			for (Kirja book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	 
}
