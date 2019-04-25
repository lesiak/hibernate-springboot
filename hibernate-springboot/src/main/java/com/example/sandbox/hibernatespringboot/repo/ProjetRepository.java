package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProjetRepository
        extends JpaRepository<Projet, Long>,
        QuerydslPredicateExecutor<Projet>,ProjetRepositoryCustom {
}
