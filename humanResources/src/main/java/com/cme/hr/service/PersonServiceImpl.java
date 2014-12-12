package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.PersonNotFound;
import com.cme.hr.model.Person;
import com.cme.hr.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Resource
	private PersonRepository personRepository;

	@Override
	@Transactional
	public Person create(Person person) {
		Person createdPerson = person;
		return personRepository.save(createdPerson);
	}
	
	@Override
	@Transactional
	public Person findById(int id) {
		return personRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=PersonNotFound.class)
	public Person delete(int id) throws PersonNotFound {
		Person deletedPerson = personRepository.findOne(id);
		
		if (deletedPerson == null)
			throw new PersonNotFound();
		
		personRepository.delete(deletedPerson);
		return deletedPerson;
	}

	@Override
	@Transactional
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=PersonNotFound.class)
	public Person update(Person person) throws PersonNotFound {
		Person updatedPerson = personRepository.findOne(person.getIdPerson());
		
		if (updatedPerson == null)
			throw new PersonNotFound();
		
		updatedPerson.setFirstname(person.getFirstname());
		updatedPerson.setMiddlename(person.getMiddlename());
		updatedPerson.setLastname(person.getLastname());
		updatedPerson.setIdType(person.getIdType());
		updatedPerson.setIdNumber(person.getIdNumber());
		updatedPerson.setCuil(person.getCuil());		
		updatedPerson.setGender(person.getGender());
		updatedPerson.setMaritalStatus(person.getMaritalStatus());
		updatedPerson.setNationality(person.getNationality());
		updatedPerson.setBirthdate(person.getBirthdate());

		updatedPerson.setAddress1(person.getAddress1());
		updatedPerson.setAddress2(person.getAddress2());
		updatedPerson.setCity(person.getCity());
		updatedPerson.setProvince(person.getProvince());
		updatedPerson.setZipCode(person.getZipCode());
		updatedPerson.setCountry(person.getCountry());

		updatedPerson.setPhone(person.getPhone());
		updatedPerson.setMovile(person.getMovile());
		updatedPerson.setWorkphone(person.getWorkphone());

		updatedPerson.setEmail(person.getEmail());
		updatedPerson.setWorkemail(person.getWorkemail());

		updatedPerson.setState(person.getState());
		
		return updatedPerson;
	}

}
