package com.example.sandbox.hibernatespringboot.model.common;

import lombok.*;

import javax.persistence.*;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Entity(name = "bar")
    public class Bar {

        @Id
        @Column(name = "bar_id", nullable = false, unique = true, columnDefinition = "bigint(20)")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long barId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "foo_id")
        Foo foo;

        private String key;
        private String value;
        @Column(name = "_deleted_")
        private Short deleted;
    }