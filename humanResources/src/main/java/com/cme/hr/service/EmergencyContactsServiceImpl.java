package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.EmergencyContactsNotFound;
import com.cme.hr.model.EmergencyContacts;
import com.cme.hr.repository.EmergencyContactsRepository;

@Service
public class EmergencyContactsServiceImpl implements EmergencyContactsService {

	@Resource
	private EmergencyContactsRepository emergencyContactsRepository;

	@Override
	@Transactional
	public EmergencyContacts create(EmergencyContacts emergencyContacts) {
		EmergencyContacts createdEmergencyContacts = emergencyContacts;
		return emergencyContactsRepository.save(createdEmergencyContacts);
	}

	@Override
	@Transactional
	public EmergencyContacts findById(int id) {
		return emergencyContactsRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<EmergencyContacts> findByIdPerson(int idPerson) {
		return emergencyContactsRepository.findByIdPerson(idPerson);
	}

	@Override
	@Transactional(rollbackFor = EmergencyContactsNotFound.class)
	public EmergencyContacts delete(int id) throws EmergencyContactsNotFound {
		EmergencyContacts deletedEmergencyContacts = emergencyContactsRepository.findOne(id);

		if (deletedEmergencyContacts == null)
			throw new EmergencyContactsNotFound();

		emergencyContactsRepository.delete(deletedEmergencyContacts);
		return deletedEmergencyContacts;
	}

	@Override
	@Transactional
	public List<EmergencyContacts> findAll() {
		return emergencyContactsRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = EmergencyContactsNotFound.class)
	public EmergencyContacts update(EmergencyContacts emergencyContacts) throws EmergencyContactsNotFound {
		EmergencyContacts updatedEmergencyContacts = emergencyContactsRepository.findOne(emergencyContacts
				.getIdEC());

		if (updatedEmergencyContacts == null)
			throw new EmergencyContactsNotFound();

		updatedEmergencyContacts.setFullName(emergencyContacts.getFullName());
		updatedEmergencyContacts.setRelationship(emergencyContacts.getRelationship());
		updatedEmergencyContacts.setMovile(emergencyContacts.getMovile());

		return updatedEmergencyContacts;
	}



}
