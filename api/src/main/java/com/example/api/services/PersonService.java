package com.example.api.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.converters.DozerMapper;
import com.example.api.converters.custom.PersonMapper;
import com.example.api.data.models.Person;
import com.example.api.data.vo.PersonVO;
import com.example.api.data.vo.v2.PersonVOV2;
import com.example.api.exceptions.ResourceNotFoundException;
import com.example.api.repositories.PersonRepository;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonMapper mapper;

    @Autowired
    private PersonRepository personRepository;

    public List<PersonVO> findAll() {
        logger.info("Finding all persons");

        return DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person");

        var entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Meu pipi no seu popo"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVOV2 createPersonV2(PersonVOV2 person) {
        logger.info("Creating a person");

        var entity = mapper.convertVoTOEntity(person);
        var vo =  mapper.convertEntityToVo(personRepository.save(entity));

        return vo;
    }

    public PersonVO createPerson(PersonVO person) {
        logger.info("Creating a person");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo =  DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Updating a person");

        var entity = personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo =  DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
		return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting the person " + id);

        var entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        personRepository.delete(entity);
    }

}
