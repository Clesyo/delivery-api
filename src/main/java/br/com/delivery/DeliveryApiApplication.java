package br.com.delivery;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.delivery.seeders.DefaultSeeder;

@SpringBootApplication
public class DeliveryApiApplication {

	@Autowired
	private DefaultSeeder seeder;
	
	@Autowired
	private DeliveryApiContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		context.load();
		seeder.seedStatesAndCities();
		seeder.seedProfiles();
		seeder.seedUser();
	}
}
