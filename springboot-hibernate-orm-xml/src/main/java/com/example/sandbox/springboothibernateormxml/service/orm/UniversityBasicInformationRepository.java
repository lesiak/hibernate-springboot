package com.example.sandbox.springboothibernateormxml.service.orm;

import com.example.sandbox.springboothibernateormxml.model.orm.UniversityBasicInformation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UniversityBasicInformationRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<UniversityBasicInformation> getUniversityList(Integer surveyYear, String stateCode, String type,
                                                              String speciality, String districtCode) {

        Session currentSession = entityManager.unwrap(Session.class);
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<UniversityBasicInformation> criteriaQuery = builder.createQuery(UniversityBasicInformation.class);
        Root<UniversityBasicInformation> root = criteriaQuery.from(UniversityBasicInformation.class);


        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(builder.equal(root.get("surveyYear"), surveyYear));//line with error

        if (stateCode != null) {

            predicates.add(builder.equal(root.get("state"), stateCode));

        }
        Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
        criteriaQuery.select(root).where(predicatesArray);
        Query<UniversityBasicInformation> query = currentSession.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
