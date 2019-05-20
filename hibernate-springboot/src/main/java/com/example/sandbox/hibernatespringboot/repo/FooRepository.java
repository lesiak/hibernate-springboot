package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FooRepository
        extends JpaRepository<Foo, Long>,
        FooRepositoryCustom,
        QuerydslPredicateExecutor<Foo> {
}
