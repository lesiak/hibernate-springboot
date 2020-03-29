package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PojoNPlusOneTest {

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @BeforeEach
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
