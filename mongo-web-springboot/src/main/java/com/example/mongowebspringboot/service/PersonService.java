package com.example.mongowebspringboot.service;

import com.example.mongowebspringboot.domain.Person;
import com.example.mongowebspringboot.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public void addPerson(Person p) {
        personRepository.save(p);
    }


    public void deleteAll() {
        personRepository.deleteAll();
    }

    public List<Person> getExistingIds(List<Long> ids) {
        return personRepository.getExistingIds(ids);
    }
}
