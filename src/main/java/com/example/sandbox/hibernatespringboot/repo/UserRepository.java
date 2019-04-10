package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository
        extends JpaRepository<User, String>,
        UserRepositoryCustom,
        QuerydslPredicateExecutor<User> {
}
