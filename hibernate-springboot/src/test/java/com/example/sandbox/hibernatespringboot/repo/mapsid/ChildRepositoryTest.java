package com.example.sandbox.hibernatespringboot.repo.mapsid;


import javax.persistence.EntityManager;

import com.example.sandbox.hibernatespringboot.model.common.mapsid.Child;
import com.example.sandbox.hibernatespringboot.model.common.mapsid.Parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildRepositoryTest {

    @Autowired
    ChildRepository childRepo;

    @Autowired
    ParentRepository parentRepo;

    @Autowired
    EntityManager entityManager;

@Test
@Transactional
public void testSpringDataJpaRepository() {
    Parent pA = parentRepo.save(Parent.builder().code("A").build());
    Child child = Child.builder().parent(pA).build();
    childRepo.save(child);
}

    @Test // WORKS!
    @Transactional
    public void testEntityManager() {

        Parent p = Parent.builder().code("A").build();
        entityManager.persist(p);

        Child child = Child.builder().parent(p).build();
        entityManager.merge(child);

//        log.info(entityManager.find(Parent.class, "A").toString());
 //       log.info(entityManager.find(Child.class, "A").toString());

    }
}

