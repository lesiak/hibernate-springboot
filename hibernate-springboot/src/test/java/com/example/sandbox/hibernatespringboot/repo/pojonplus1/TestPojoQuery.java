package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPojoQuery {

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @Test
    public void testFindAll() {
        simpleEntityRepository.findAll();
    }
}
