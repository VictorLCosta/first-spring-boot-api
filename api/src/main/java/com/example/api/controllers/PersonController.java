package com.example.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.models.Person;
import com.example.api.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAll() throws Exception {
        return personService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable(value = "id") String id) throws Exception {
        return personService.findById(id);
    }

}
