package com.example.sandbox.hibernatespringboot.model.naturalid;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    private Long isbn;

    private String title;

    public BookEntity() {
    }

    public BookEntity(long isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
