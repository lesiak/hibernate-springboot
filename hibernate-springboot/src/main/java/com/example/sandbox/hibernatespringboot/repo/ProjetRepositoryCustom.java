package com.example.sandbox.hibernatespringboot.repo;

import com.example.sandbox.hibernatespringboot.model.common.Projet;

import java.util.List;

public interface ProjetRepositoryCustom {

    List<Projet> findByCommuneId(String communeId);

}
