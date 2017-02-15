package com.friendlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.friendlist.domain.Friend;
import com.friendlist.domain.FriendRepository;


@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner friendList(FriendRepository repository) {
		return (args) -> {
			
			log.info("haetaan kaikki kaverit");
			for (Friend friend : repository.findAll()) {
				log.info(friend.toString());
			}

		};
	}
}
