package com.example.sandbox.hibernatespringboot.model.orphantest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChildIntId{
    @Id
    public long cid;

    public String name;

    @ManyToOne
    @JoinColumn(name = "foreignKeyFromParent")
    public ParentIntId parent;

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentIntId getParent() {
        return parent;
    }

    public void setParent(ParentIntId parent) {
        this.parent = parent;
    }
}
