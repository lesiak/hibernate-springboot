package com.example.sandbox.hibernatespringboot.model.orphantest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ParentIntId {
    @Id
    public long pid;

    public String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    public List<ChildIntId> children;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChildIntId> getChildren() {
        return children;
    }

    public void setChildren(List<ChildIntId> children) {
        this.children = children;
    }
}
