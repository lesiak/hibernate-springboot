package com.example.sandbox.hibernatespringboot.repo.orphantest;

import com.example.sandbox.hibernatespringboot.model.orphantest.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentOrphanRepository extends JpaRepository<Parent, Long> {
}
