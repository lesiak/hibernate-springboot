package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPojoQuery {

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setup() {
        simpleEntityRepository.deleteAll();
        simpleEntityRepository.save(new SimpleEntity(1L, "aaa"));
        simpleEntityRepository.save(new SimpleEntity(2L, "bbb"));
    }

    @Test
    public void testFindAll() {
        simpleEntityRepository.findAll();
    }

    @Test
    public void testGetRecords() {
        simpleEntityRepository.getRecords();
    }
}
