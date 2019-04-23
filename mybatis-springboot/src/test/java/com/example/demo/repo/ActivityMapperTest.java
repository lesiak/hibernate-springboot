package com.example.demo.repo;

import com.example.demo.model.Activities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityMapperTest {

    @Autowired
    private ActivityMapper activityMapper;

    @Test
    public void testSaveAndFindAll() {
        List<Activities> findAll = activityMapper.getActivities(1, "AAA");
        System.out.println(findAll);

    }

}