package com.example.h2customizationspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2CustomizationSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(H2CustomizationSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AAA");
	}
}
