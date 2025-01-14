package com.ecosystem.evstationsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;


@EnableScheduling
@SpringBootApplication
public class EvstationsserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvstationsserviceApplication.class, args);
	}

}
