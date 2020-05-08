package com.example.sandbox.hibernatespringboot.repo.cascadetoparent;

import com.example.sandbox.hibernatespringboot.model.cascadetoparent.ConfigurationEntry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationEntryRepository extends JpaRepository<ConfigurationEntry, Long> {
}
