package com.example.sandbox.hibernatespringboot.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjetRepositoryTest {

    @Autowired
    private ProjetRepository repository;

    @Test
    public void testSubQuery() {
        repository.findByCommuneId("london");
    }
}