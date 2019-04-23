package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.User;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> findMultiple(List<String> userIds);

    List<User> findQueryDsl(Predicate predicate);

}
