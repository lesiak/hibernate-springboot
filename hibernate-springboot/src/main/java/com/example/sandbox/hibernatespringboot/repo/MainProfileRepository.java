package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.Foo;
import com.example.sandbox.hibernatespringboot.model.common.MainProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MainProfileRepository
        extends JpaRepository<MainProfile, String> {
}
