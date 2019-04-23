package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.CommProfile;
import com.example.sandbox.hibernatespringboot.model.common.MainProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommProfileRepository
        extends JpaRepository<CommProfile, String> {
}
