package com.example.sandbox.hibernatespringboot.model.common.mapsid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@Table(name = "child")
@NoArgsConstructor
@AllArgsConstructor
public class Child {

    @Id
    @Column(name = "code", insertable = false, updatable = false)
    String code;

    @MapsId
    @JoinColumn(name = "code")
    @OneToOne
    Parent parent;
}