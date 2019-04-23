package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.Foo;
import com.example.sandbox.hibernatespringboot.model.common.User;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface FooRepositoryCustom {

    List<Foo> findActive();

}
