package com.example.sandbox.hibernatespringboot.model.common;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(name = "projet")
public class Projet {

    @Id
    @Column(name = "id", nullable = false, unique = true, columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
