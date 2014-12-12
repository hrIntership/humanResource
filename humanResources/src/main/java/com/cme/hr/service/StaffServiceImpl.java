package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.StaffNotFound;
import com.cme.hr.model.Staff;
import com.cme.hr.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Resource
	private StaffRepository staffRepository;

	@Override
	@Transactional
	public Staff create(Staff staff) {
		Staff createdStaff = staff;
		return staffRepository.save(createdStaff);
	}
	
	@Override
	@Transactional
	public Staff findById(int id) {
		return staffRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff delete(int id) throws StaffNotFound {
		Staff deletedStaff = staffRepository.findOne(id);
		
		if (deletedStaff == null)
			throw new StaffNotFound();
		
		staffRepository.delete(deletedStaff);
		return deletedStaff;
	}

	@Override
	@Transactional
	public List<Staff> findAll() {
		return staffRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=StaffNotFound.class)
	public Staff update(Staff staff) throws StaffNotFound {
		Staff updatedStaff = staffRepository.findOne(staff.getIdPerson());
		
		if (updatedStaff == null)
			throw new StaffNotFound();
		
		updatedStaff.setDateFrom(staff.getDateFrom());
		updatedStaff.setDateTo(staff.getDateTo());
		updatedStaff.setSalary(staff.getSalary());
		updatedStaff.setTasks(staff.getTasks());
		updatedStaff.setWorkspace(staff.getWorkspace());
		updatedStaff.setAgreement(staff.getAgreement());		
		updatedStaff.setCategory(staff.getCategory());
		updatedStaff.setHealthInsurance(staff.getHealthInsurance());

		return updatedStaff;
	}

	@Override
	@Transactional
	public List<Staff> findByIdPerson(Integer idPerson) {
		return staffRepository.findByIdPerson(idPerson);

	}

}