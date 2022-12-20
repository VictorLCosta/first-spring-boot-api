package com.example.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.api.models.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        var persons = new ArrayList<Person>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);

            persons.add(person);
        }

        return persons;
    }

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

    public Person createPerson(Person person) {
        logger.info("Creating a person");

        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating a person");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting the person " + id);
    }

    private Person mockPerson(int i) {
        var person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brazil " + i);
        person.setGender("Unknown");

        return person;
    }

}
