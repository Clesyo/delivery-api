package br.com.delivery;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.delivery.model.seeders.DefaultSeeder;

@SpringBootApplication
public class DeliveryApiApplication {

	@Autowired
	private DefaultSeeder seeder;
	
	public static void main(String[] args) {
		SpringApplication.run(DeliveryApiApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		seeder.seedStatesAndCities();
	}
}
