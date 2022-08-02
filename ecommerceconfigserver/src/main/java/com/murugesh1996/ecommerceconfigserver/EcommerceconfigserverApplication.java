package com.murugesh1996.ecommerceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EcommerceconfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceconfigserverApplication.class, args);
	}

}
