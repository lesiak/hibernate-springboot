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

    @Embeddable
    @EqualsAndHashCode
    @ToString
    public static class PK implements Serializable {
        public long parentPk;
        public long cid;
    }

}
