package com.PickOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class PickOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickOneApplication.class, args);
	}

}
