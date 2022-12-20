package com.example.api.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.exceptions.ResourceNotFoundException;
import com.example.api.models.Person;
import com.example.api.repositories.PersonRepository;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("Finding all persons");

        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person");

        return personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Meu pipi no seu popo"));
    }

    public Person createPerson(Person person) {
        logger.info("Creating a person");

        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating a person");

        var entity = personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting the person " + id);

        var entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        personRepository.delete(entity);
    }

}
