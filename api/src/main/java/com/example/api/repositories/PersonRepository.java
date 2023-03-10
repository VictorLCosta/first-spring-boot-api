package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.data.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
