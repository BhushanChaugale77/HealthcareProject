package com.xcure;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppointmentManagementService1Application {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentManagementService1Application.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		return new  ModelMapper();
	}
	
	
}
