package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {
}
