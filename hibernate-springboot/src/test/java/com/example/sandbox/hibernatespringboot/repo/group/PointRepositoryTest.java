package com.example.sandbox.hibernatespringboot.repo.group;

import com.example.sandbox.hibernatespringboot.model.group.Point;
import com.example.sandbox.hibernatespringboot.repo.mapsid.ParentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointRepositoryTest {

    @Autowired
    PointRepository pointRepo;

    @Autowired
    EntityManager entityManager;

    @Test
    public void testJPQLQuery() {
        TypedQuery<Object[]> query = entityManager.createQuery(
                "select p.pointIdentity.id, max(p.pointIdentity.timestamp) from Point p group by p.pointIdentity.id",
                Object[].class);
        List<Object[]> results = query.getResultList();
        System.out.println(results);
    }

    @Test
    public void testCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<Point> point = query.from(Point.class);
        query.groupBy(point.get("pointIdentity").get("id"));
        query.multiselect(
                point.get("pointIdentity").get("id"),
                criteriaBuilder.max(point.get("pointIdentity").get("timestamp"))
        );
        TypedQuery<Object[]> typedQuery = entityManager.createQuery(query);
        List<Object[]> results = typedQuery.getResultList();
        System.out.println(results);
    }

}
