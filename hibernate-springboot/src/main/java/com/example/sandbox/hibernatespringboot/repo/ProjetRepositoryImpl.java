package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.Projet;
import com.example.sandbox.hibernatespringboot.model.QLocalisation;
import com.example.sandbox.hibernatespringboot.model.QProjet;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProjetRepositoryImpl implements ProjetRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Projet> findByCommuneId(String communeId) {
        QProjet prj = QProjet.projet;

        BooleanBuilder where_loc = new BooleanBuilder();
        QLocalisation loc_2 = new QLocalisation("loc_2");
        where_loc.and(prj.id.in(
                JPAExpressions.select(loc_2.projet.id)
                        .from(loc_2)
                        .where(loc_2.commune.eq(communeId))
        ));

        JPAQuery<Projet> query = new JPAQuery<>(entityManager);
        return query.select(prj)
                .from(prj)
                .where(where_loc)
                .fetch();
    }
}
