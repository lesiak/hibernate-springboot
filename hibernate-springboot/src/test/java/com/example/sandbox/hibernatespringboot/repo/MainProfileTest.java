package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.CommProfile;
import com.example.sandbox.hibernatespringboot.model.common.Foo;
import com.example.sandbox.hibernatespringboot.model.common.MainProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainProfileTest {

    @Autowired
    private AService aService;

    @Autowired
    private CommProfileRepository commProfileRepository;

    @Test
    public void testSaveAndFindAll() {
        aService.testSaveAndFindAll();
    }
}