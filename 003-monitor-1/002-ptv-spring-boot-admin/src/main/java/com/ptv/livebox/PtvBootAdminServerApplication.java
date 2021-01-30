package com.ptv.livebox;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class PtvBootAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtvBootAdminServerApplication.class, args);
	}

}
