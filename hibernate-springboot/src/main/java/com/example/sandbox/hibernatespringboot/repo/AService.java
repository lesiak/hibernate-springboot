package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.CommProfile;
import com.example.sandbox.hibernatespringboot.model.common.MainProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Service
public class AService {

    @Autowired
    private MainProfileRepository mainProfileRepository;

    @Autowired
    private CommProfileRepository commProfileRepository;

    @Autowired
    private EntityManager em;

    @Transactional
    public void testSaveAndFindAll() {
        String customerId = "aaa";

        CommProfile commProfile = new CommProfile();

        MainProfile mainProfile = new MainProfile(customerId, commProfile);
        //mainProfileRepository.save(mainProfile);
        //System.out.println("MainProfile");
       // var comProfile2 = commProfileRepository.save(commProfile);
       // System.out.println(comProfile2.getMainprofile());
        em.persist(mainProfile);
    }
}
