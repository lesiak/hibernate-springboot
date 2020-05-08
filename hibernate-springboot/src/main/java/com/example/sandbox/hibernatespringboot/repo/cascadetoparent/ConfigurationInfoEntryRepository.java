package com.example.sandbox.hibernatespringboot.repo.cascadetoparent;

import com.example.sandbox.hibernatespringboot.model.cascadetoparent.ConfigurationInfoEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationInfoEntryRepository extends JpaRepository<ConfigurationInfoEntry, Long> {
}
