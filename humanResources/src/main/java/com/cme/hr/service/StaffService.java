package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.StaffNotFound;
import com.cme.hr.model.FamilyMember;
import com.cme.hr.model.Staff;

public interface StaffService {
	
	public Staff create(Staff staff);
	public Staff delete(int id) throws StaffNotFound;
	public List<Staff> findAll();
	public Staff update(Staff staff) throws StaffNotFound;
	public Staff findById(int id);
	public List<Staff> findByIdPerson(Integer idPerson);

}