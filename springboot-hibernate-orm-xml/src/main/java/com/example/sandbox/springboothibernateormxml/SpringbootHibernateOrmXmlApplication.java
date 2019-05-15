package com.example.sandbox.springboothibernateormxml;

import com.example.sandbox.springboothibernateormxml.model.basic.DummyEntity;
import com.example.sandbox.springboothibernateormxml.service.basic.DummyEntityRepository;
import com.example.sandbox.springboothibernateormxml.service.orm.UniversityBasicInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootApplication
public class SpringbootHibernateOrmXmlApplication implements CommandLineRunner {

	@Autowired
	private DummyEntityRepository dummyEntityRepository;

	@Autowired
	private UniversityBasicInformationRepository universityBasicInformationRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateOrmXmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	dummyEntityRepository.persist(new DummyEntity());
		universityBasicInformationRepository.getUniversityList(2000, "CA", "type", "spec", "dist");
	}


}
