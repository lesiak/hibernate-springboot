package com.example.sandbox.hibernatespringboot.model.joinmanymany;

import javax.persistence.*;
@Entity(name = "foo1")
public class Foo1 {

    @Id
    @Column(name = "foo_id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fooId;

    @Column(name = "BAR_ID")
    private Long barId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false)
    private Bar1 bar;

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public Bar1 getBar() {
        return bar;
    }

    public Long getFooId() {
        return fooId;
    }

    public void setFooId(Long fooId) {
        this.fooId = fooId;
    }


}
