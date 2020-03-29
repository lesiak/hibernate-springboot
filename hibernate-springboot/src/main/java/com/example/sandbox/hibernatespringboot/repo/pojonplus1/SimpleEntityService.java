package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import com.example.sandbox.hibernatespringboot.model.pojonplus1.Pair;
import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntity;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Service
public class SimpleEntityService {

    private final SimpleEntityRepository simpleEntityRepository;

    private final EntityManager entityManager;

    public SimpleEntityService(SimpleEntityRepository simpleEntityRepository,
                               EntityManager entityManager) {
        this.simpleEntityRepository = simpleEntityRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public void changeValueInFirstEntity() {
        var all = simpleEntityRepository.findAll();
        var firstEntity = all.get(0);
        var managed = entityManager.contains(firstEntity);
        System.out.println("managed: " + managed);
        firstEntity.setText("fafas");
        var aaa = 1;
    }

    @Transactional
    public void changeValueInFirstRecord() {
        List<Pair<SimpleEntity, Boolean>> all = simpleEntityRepository.getRecords();
        SimpleEntity firstEntity = all.get(0).getFirst();
        boolean managed = entityManager.contains(firstEntity);
        System.out.println("managed: " + managed);
        firstEntity.setText("fafas");
        var aaa = 1;
    }

    @Transactional
    public void changeValueInFirstEntityViaTransformer() {
        List<Pair<SimpleEntity, Boolean>> all = entityManager.createQuery(
                "select m as first, false as second from SimpleEntity m")
                .unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(Transformers.aliasToBean(Pair.class))
                .getResultList();
        SimpleEntity firstEntity = all.get(0).getFirst();
        boolean managed = entityManager.contains(firstEntity);
        System.out.println("managed: " + managed);
        firstEntity.setText("new_value");
    }
}
