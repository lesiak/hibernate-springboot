package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.Foo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FooRepositoryTest {

    @Autowired
    private FooRepository repository;

    @Test
    public void testSaveAndFindAll() {
        List<Foo> findActive = repository.findActive();
        assertThat(findActive).hasSize(2);
        System.out.println(findActive.get(0).getBars().size());
        System.out.println(findActive.get(1).getBars().size());
    }
}
