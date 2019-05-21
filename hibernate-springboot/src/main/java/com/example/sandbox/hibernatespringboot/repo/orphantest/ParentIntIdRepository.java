package com.example.sandbox.hibernatespringboot.repo.orphantest;

import com.example.sandbox.hibernatespringboot.model.orphantest.ParentIntId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentIntIdRepository extends JpaRepository<ParentIntId, Long> {
}
