package com.example.sandbox.springboothibernateormxml.service.basic;

import com.example.sandbox.springboothibernateormxml.model.basic.DummyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class DummyEntityRepository {

    private EntityManager entityManager;

    @Autowired
    public DummyEntityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void persist(DummyEntity dummyEntity) {
        entityManager.persist(dummyEntity);
    }
}
