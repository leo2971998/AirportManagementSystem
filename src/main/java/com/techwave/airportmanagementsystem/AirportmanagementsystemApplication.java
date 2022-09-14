package com.techwave.airportmanagementsystem;

import com.techwave.airportmanagementsystem.model.dao.AirplaneRepository;
import com.techwave.airportmanagementsystem.model.dao.DatabaseDao;
import com.techwave.airportmanagementsystem.model.dao.RegistrationDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;

@SpringBootApplication
public class AirportmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportmanagementsystemApplication.class, args);
	}
	@Bean
	public RegistrationDao registrationDao() {
		return new RegistrationDao();
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public DatabaseDao databaseDao() {
		return new DatabaseDao();
	}
}
