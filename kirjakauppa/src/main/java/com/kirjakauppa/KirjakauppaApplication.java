package com.kirjakauppa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kirjakauppa.domain.Book;
import com.kirjakauppa.domain.BookRepository;
import com.kirjakauppa.domain.User;
import com.kirjakauppa.domain.UserRepository;



@SpringBootApplication
public class KirjakauppaApplication {
	private static final Logger log = LoggerFactory.getLogger(KirjakauppaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KirjakauppaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(BookRepository repository, UserRepository urepository) {
		return (args) -> {
			log.info("Lisätään esimerkki kirjoja");
			repository.save(new Book("1984", "George Orwell", "1949", "123456-123", "3,50"));
			repository.save(new Book("Mein Kampf", "Adolf Hitler", "1926", "0395083621", "14"));	
			
			log.info("Lisätään esimerkki käyttäjät");
			User user1 = new User("useri", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admini", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("hae kaikki kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
