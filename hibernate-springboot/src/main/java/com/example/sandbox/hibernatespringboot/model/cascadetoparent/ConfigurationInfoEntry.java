package com.example.sandbox.hibernatespringboot.model.cascadetoparent;

import javax.persistence.*;

@Entity
public class ConfigurationInfoEntry {

    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
