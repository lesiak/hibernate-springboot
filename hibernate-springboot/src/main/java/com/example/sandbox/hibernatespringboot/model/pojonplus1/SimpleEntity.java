package com.example.sandbox.hibernatespringboot.model.pojonplus1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleEntity {
    @Id
    private Long id;

    @Column(name = "text")
    private String text;

    public SimpleEntity() {
    }

    public SimpleEntity(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
