package com.ptv.livebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PtvMoviesServiceApplication {

	@GetMapping("/health")
	public String health() {
		return "OK";
	}

	public static void main(String[] args) {
		SpringApplication.run(PtvMoviesServiceApplication.class, args);
	}

}
