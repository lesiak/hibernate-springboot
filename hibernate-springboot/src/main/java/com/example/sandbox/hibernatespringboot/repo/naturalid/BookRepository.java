package com.example.sandbox.hibernatespringboot.repo.naturalid;

import com.example.sandbox.hibernatespringboot.model.naturalid.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
