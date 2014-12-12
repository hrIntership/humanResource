package com.cme.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}