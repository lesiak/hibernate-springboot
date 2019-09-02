package com.example.mongowebspringboot.repo;

import com.example.mongowebspringboot.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, Long> {
    @Query(value = "{ '_id': { '$in': ?0} }", fields = "{ '_id': 1}")
    List<Person> getExistingIds(List<Long> ids);
}
