package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.EmergencyContacts;

public interface EmergencyContactsRepository extends JpaRepository<EmergencyContacts, Integer> {

	List<EmergencyContacts> findByIdPerson(Integer idPerson);

}