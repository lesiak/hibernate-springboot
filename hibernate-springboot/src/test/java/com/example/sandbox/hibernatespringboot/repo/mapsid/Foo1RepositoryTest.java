package com.example.sandbox.hibernatespringboot.repo.mapsid;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Foo1RepositoryTest {



    @Autowired
    EntityManager entityManager;



    @Test // WORKS!
    @Transactional
    public void testEntityManager() {

      //  Foo1 foo1 = entityManager.find(Foo1.class, 1l);
       // System.out.println(foo1);
    }
}

