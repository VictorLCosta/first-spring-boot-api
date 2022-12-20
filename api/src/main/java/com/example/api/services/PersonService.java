package com.example.api.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.api.models.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person");

        var person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Victor");
        person.setLastName("Lima");
        person.setAddress("Rua Auimbaue - 232");
        person.setGender("Male");

        return person;
    }

}
