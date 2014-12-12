package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.EmergencyContactsNotFound;
import com.cme.hr.model.EmergencyContacts;

public interface EmergencyContactsService {
	
	public EmergencyContacts create(EmergencyContacts emergencyContacts);
	public EmergencyContacts delete(int id) throws EmergencyContactsNotFound;
	public List<EmergencyContacts> findAll();
	public List<EmergencyContacts> findByIdPerson(int idPerson);
	public EmergencyContacts update(EmergencyContacts emergencyContacts) throws EmergencyContactsNotFound;
	public EmergencyContacts findById(int id);

}
