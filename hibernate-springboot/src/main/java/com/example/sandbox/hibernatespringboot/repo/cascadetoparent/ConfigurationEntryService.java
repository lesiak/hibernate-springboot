package com.example.sandbox.hibernatespringboot.repo.cascadetoparent;

import com.example.sandbox.hibernatespringboot.model.cascadetoparent.ConfigurationEntry;
import com.example.sandbox.hibernatespringboot.model.cascadetoparent.ConfigurationInfoEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;

@Service

public class ConfigurationEntryService {

    @Autowired
    private ConfigurationEntryRepository configurationEntryRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Transactional
    public Long persistNewConfigEntry() {
        var configurationInfoEntry = new ConfigurationInfoEntry();
       // configurationInfoEntry  = configurationInfoEntryRepository.saveAndFlush(configurationInfoEntry);
        entityManager.persist(configurationInfoEntry);
        System.out.println("AAA configurationInfoEntryId" + configurationInfoEntry.getId());
       // boolean c = entityManager.contains(configurationInfoEntry);
        var configurationEntry = new ConfigurationEntry(configurationInfoEntry);
        configurationEntry = configurationEntryRepository.save(configurationEntry);
//
        System.out.println(configurationEntry.getId());
        return  configurationEntry.getId();

    }

    @Transactional
    public void addNewConfigEntry(Long configurationEntryId) {
        System.out.println(TransactionAspectSupport.currentTransactionStatus());
        var entry = configurationEntryRepository.getOne(configurationEntryId);
        System.out.println(entry);
        final ConfigurationEntry configurationEntry = new ConfigurationEntry(entry.getInfoEntry());
        configurationEntryRepository.saveAndFlush(configurationEntry);
    }
}
