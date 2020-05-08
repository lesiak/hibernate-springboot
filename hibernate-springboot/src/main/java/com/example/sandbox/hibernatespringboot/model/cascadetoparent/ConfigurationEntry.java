package com.example.sandbox.hibernatespringboot.model.cascadetoparent;

import javax.persistence.*;

@Entity
public class ConfigurationEntry {
    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "info_entry")
    @ManyToOne(cascade = CascadeType.ALL)
    private ConfigurationInfoEntry infoEntry;

    public ConfigurationEntry() {
    }

    public ConfigurationEntry(ConfigurationInfoEntry infoEntry) {
        this.infoEntry = infoEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConfigurationInfoEntry getInfoEntry() {
        return infoEntry;
    }

    public void setInfoEntry(ConfigurationInfoEntry infoEntry) {
        this.infoEntry = infoEntry;
    }
}
