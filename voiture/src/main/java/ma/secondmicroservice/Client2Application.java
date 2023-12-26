package ma.secondmicroservice;

import org.springframework.boot.CommandLineRunner;		
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.transaction.Transactional;
import ma.secondmicroservice.model.Client;
import ma.secondmicroservice.model.Voiture;
import ma.secondmicroservice.repository.VoitureRepository;

@EnableFeignClients
@SpringBootApplication
public class Client2Application {
	public static void main(String[] args) {
		SpringApplication.run(Client2Application.class, args);
	}

	@FeignClient(name = "SERVICE-CLIENT")
	interface ClientService {
		@GetMapping(path = "/clients/client/{id}")
		Client clientById(@PathVariable int id);
	}

	@Transactional
	@Bean
	CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService) {
		return args -> {
			Client c1 = clientService.clientById(2);
			Client c2 = clientService.clientById(1);
			System.out.println("**************************");
			System.out.println("Id est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");
			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Age est :" + c1.getAge());
			System.out.println("**************************");
			Voiture voiture = new Voiture(1, "Toyota", "A25 333", "Corolla", 1, c2);
			System.out.println(voiture);
			voitureRepository.save(voiture);
			voitureRepository.save(new Voiture(2, "Renault", "B 6 3456", "Megane", 1, c2));
			voitureRepository.save(new Voiture(3, "Peugeot", "A 55 4444", "301", 2, c1));
			for(Voiture v : voitureRepository.findAll())
				System.out.println(v);
		};
	}
}
