package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.MainProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainProfileRepository
        extends JpaRepository<MainProfile, String> {
}
