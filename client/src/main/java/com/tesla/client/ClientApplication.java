package com.tesla.client;

import com.tesla.client.entities.Client;
import com.tesla.client.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeMySQLDatabase(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(null, "Amine SAFI", 23.0F));
			clientRepository.save(new Client(null, "Amal ALAOUI", 22.0F));
			clientRepository.save(new Client(null, "Samir RAMI", 22.0F));
		};
	}

}
