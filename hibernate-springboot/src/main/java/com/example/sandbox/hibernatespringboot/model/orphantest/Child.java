package com.example.sandbox.hibernatespringboot.model.orphantest;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "ChildOrphan")
public class Child{
    @EmbeddedId
    public PK childPK = new PK();

    public String name;

    @ManyToOne
    @MapsId("parentPk")
    @JoinColumn(name = "foreignKeyFromParent"/*, insertable = false, updatable = false*/)
    public Parent parent;

    public PK getChildPK() {
        return childPK;
    }

    public void setChildPK(PK childPK) {
        this.childPK = childPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Embeddable
    @EqualsAndHashCode
    @ToString
    public static class PK implements Serializable {
        public long parentPk;
        public long cid;
    }

}
