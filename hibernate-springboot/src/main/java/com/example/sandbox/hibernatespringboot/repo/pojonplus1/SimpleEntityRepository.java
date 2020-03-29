package com.example.sandbox.hibernatespringboot.repo.pojonplus1;

import com.example.sandbox.hibernatespringboot.model.pojonplus1.Pair;
import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntity;
import com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {

    @Query("SELECT new com.example.sandbox.hibernatespringboot.model.pojonplus1.Pair(m, false) FROM SimpleEntity m")
    List<Pair<SimpleEntity, Boolean>> getRecords();

    @Query("SELECT new com.example.sandbox.hibernatespringboot.model.pojonplus1.SimpleEntityDTO(m.id, m.text, false) FROM SimpleEntity m")
    List<SimpleEntityDTO> getRecordsExtended();

}
