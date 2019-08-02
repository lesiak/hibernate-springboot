package com.example.jpaMetaModelGenerator;

import com.example.jpaMetaModelGenerator.entities.Person;
import com.example.jpaMetaModelGenerator.entities.Person_;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaMetaModelGeneratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaMetaModelGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = new Person();
		p.getId();
		///Person_ p;
	}
}
