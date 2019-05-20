package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.User;
import com.querydsl.core.types.Predicate;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findMultiple(List<String> userIds) {
        Session session = em.unwrap(Session.class);
        MultiIdentifierLoadAccess<User> multiLoadAccess = session.byMultipleIds(User.class);
        return multiLoadAccess.multiLoad(userIds);
    }

    @Override
    public List<User> findQueryDsl(Predicate predicate) {
      //  StringPath p = QUser.user.userId;
        //Bar b;
        //b.
       /* JPAQuery<?> query = new JPAQuery<Void>(em);
        List<MheLocation> resultList = query.select(mheLocation)
                .from(mheLocation).innerJoin(mheLocation.location).fetchJoin()
                .where(predicate)
                .fetch();*/
        return null;
    }


}
