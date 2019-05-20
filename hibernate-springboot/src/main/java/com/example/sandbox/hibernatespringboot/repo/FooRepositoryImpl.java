package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.Bar;
import com.example.sandbox.hibernatespringboot.model.Foo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
//import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class FooRepositoryImpl implements FooRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Foo> findActive() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Foo> criteria = builder.createQuery(Foo.class);
        Root<Foo> fromFoo = criteria.from(Foo.class);
        Join<Foo, Bar> foobars = (Join<Foo, Bar>)fromFoo.<Foo, Bar>fetch("bars");
      //  Join<Foo, Bar> x= (Join<Foo, Bar>) f;

        List<Predicate> conditions = new ArrayList<>();
        conditions.add(builder.isNull(fromFoo.get("deleted")));
        conditions.add(builder.isNull(foobars.get("deleted")));


    TypedQuery<Foo> typedQuery = entityManager.createQuery(
            criteria.select(fromFoo)
                    .where(conditions.toArray(new Predicate[]{}))
                     .distinct(true));

        return typedQuery.getResultList();
    }


}
