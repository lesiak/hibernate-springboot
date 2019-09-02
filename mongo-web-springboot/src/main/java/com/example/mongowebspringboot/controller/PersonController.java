package com.example.mongowebspringboot.controller;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/person")
public class PersonController {
    private final MongoTemplate mongoTemplate;

    public PersonController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
