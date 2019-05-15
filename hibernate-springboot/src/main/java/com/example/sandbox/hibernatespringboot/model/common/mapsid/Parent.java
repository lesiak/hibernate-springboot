package com.example.sandbox.hibernatespringboot.model.common.mapsid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parent")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Parent {

    @Id
    @Column(name = "code")
    String code;

    //...etc
}