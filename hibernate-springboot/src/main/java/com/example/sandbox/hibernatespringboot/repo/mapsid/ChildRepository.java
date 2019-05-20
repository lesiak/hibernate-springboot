package com.example.sandbox.hibernatespringboot.repo.mapsid;


import com.example.sandbox.hibernatespringboot.model.mapsid.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, String> {

}
