package com.example.sandbox.hibernatespringboot.model.common;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Entity(name = "foo")
    public class Foo {

        @Id
        @Column(name = "foo_id", nullable = false, unique = true, columnDefinition = "bigint(20)")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long fooId;
        private String name;
        @Column(name = "_deleted_")
        private Short deleted;

        @OneToMany(mappedBy = "foo")
        private List<Bar> bars;
    }