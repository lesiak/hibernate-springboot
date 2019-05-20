package com.example.sandbox.hibernatespringboot.model.joinmanymany;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;
@Entity(name = "bar1")
public class Bar1 {

    @Id
    @Column(name = "bar_id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barId;

    @OneToMany(mappedBy = "bar", fetch = LAZY)
    private List<Foo1> foos;

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }
}
