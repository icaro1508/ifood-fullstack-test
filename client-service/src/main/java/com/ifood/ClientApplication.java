package com.ifood;

import com.ifood.client.document.Client;
import com.ifood.client.event.ClientEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories("com.ifood.client.repository")
public class ClientApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
    @Bean
    ClientEventHandler clientEventHandler() {
        return new ClientEventHandler();
    }
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.save(Client.builder()
				.id(UUID.fromString("daa880de-3ef2-452d-a97e-e12ff9bf6113"))
				.name("John Doe")
				.email("john@doe.com")
				.phone("1234-5678")
				.build());
		
		mongoTemplate.save(Client.builder()
				.id(UUID.fromString("35521a8a-67d9-41b0-94b1-6141efe40397"))
				.name("Jane Doe")
				.email("jane@doe.com")
				.phone("1234-8765")
				.build());
		
		mongoTemplate.save(Client.builder()
				.id(UUID.fromString("e4b5af81-30a3-49e2-a687-2297b10252f0"))
				.name("Mary Boo")
				.email("mary@boo.com")
				.phone("4321-5678")
				.build());
	}
}
