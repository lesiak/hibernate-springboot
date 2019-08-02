package com.example.jpaMetaModelGenerator.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Person {

    @Id
    private long id;

    public long getId() {
    	return id;
    }
    
    public void setId(long value) {
    	id = value;
    }
}
