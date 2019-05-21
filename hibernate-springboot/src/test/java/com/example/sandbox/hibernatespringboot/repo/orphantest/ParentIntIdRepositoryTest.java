package com.example.sandbox.hibernatespringboot.repo.orphantest;

import com.example.sandbox.hibernatespringboot.model.orphantest.ChildIntId;
import com.example.sandbox.hibernatespringboot.model.orphantest.ParentIntId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ParentIntIdRepositoryTest {

    @Autowired
    private ParentIntIdRepository parentIntIdRepository;

    @Test
    public void testDoubleAdd() {
        addEntity();
        System.out.println("AAAAAAAAAAAAAAAA");
        addEntity();
    }

    @Transactional
    public void addEntity() {
        ParentIntId parent = new ParentIntId();
        parent.pid = 1;
        parent.name = "Parent 1";

       // parent = parentIntIdRepository.save(parent);


        ChildIntId child = new ChildIntId();
        List<ChildIntId> childList = new ArrayList<>();

        child.parent = parent;
        child.cid = 1;
        child.name = "Child 1";
        childList.add(child);

        parent.children = childList;
        parentIntIdRepository.save(parent);
        parentIntIdRepository.flush();
    }
}
