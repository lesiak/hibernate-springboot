package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.Foo;

import java.util.List;

public interface FooRepositoryCustom {

    List<Foo> findActive();

}
