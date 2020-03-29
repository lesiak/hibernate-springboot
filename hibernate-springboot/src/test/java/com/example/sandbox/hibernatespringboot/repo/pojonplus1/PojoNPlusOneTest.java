package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import com.example.sandbox.hibernatespringboot.model.pojonplus1.Pair;
import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntity;
import org.hibernate.transform.Transformers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
public class PojoNPlusOneTest {

    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @Autowired
    private SimpleEntityService simpleEntityService;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        simpleEntityRepository.deleteAll();
        simpleEntityRepository.save(new SimpleEntity(1L, "aaa"));
        simpleEntityRepository.save(new SimpleEntity(2L, "bbb"));
    }

    @Test
    public void testFindAll() {
        var all = simpleEntityRepository.findAll();
    }

    @Test
    public void testChangeValue() {
       simpleEntityService.changeValueInFirstEntity();
    }

    @Test
    public void testGetRecords() {
        simpleEntityRepository.getRecords();
    }

    @Test
    public void testChangeValueInRecord() {
        simpleEntityService.changeValueInFirstRecord();
    }

    @Test
    public void testGetRecordsExtended() {
        simpleEntityRepository.getRecordsExtended();
    }

    @Test
    public void testGetRecordsViaResultTransformer() {
        List<Pair<SimpleEntity, Boolean>> resultList = entityManager.createQuery(
                "select m as first, false as second from SimpleEntity m")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(Pair.class))
                .getResultList();
        System.out.println(resultList);
    }

    @Test
    public void changeValueInFirstTransformer() {
        simpleEntityService.changeValueInFirstEntityViaTransformer();
    }
}
