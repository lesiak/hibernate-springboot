package com.example.sandbox.hibernatespringboot.repo.cascadetoparent;

import com.example.sandbox.hibernatespringboot.model.cascadetoparent.ConfigurationEntry;
import com.example.sandbox.hibernatespringboot.model.cascadetoparent.ConfigurationInfoEntry;
import com.example.sandbox.hibernatespringboot.repo.orphantest.ParentIntIdRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConfigurationEntryRepositoryTest {
    @Autowired
    private ConfigurationEntryRepository configurationEntryRepository;

    @Autowired
    private ConfigurationInfoEntryRepository configurationInfoEntryRepository;

    @Autowired
    private ConfigurationEntryService configurationEntryService;

    @Autowired
    PlatformTransactionManager transactionManager;

    @BeforeEach
    public void cleanup() {
        configurationEntryRepository.deleteAll();
        configurationInfoEntryRepository.deleteAll();

    }

    @Test
    public void testDoubleAdd() {
        Long configurationEntryId = configurationEntryService.persistNewConfigEntry();
        configurationEntryService.addNewConfigEntry(configurationEntryId);
    }
}
