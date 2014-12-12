package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.EducationNotFound;
import com.cme.hr.model.Education;

public interface EducationService {
	
	public Education create(Education education);
	public Education delete(int id) throws EducationNotFound;
	public List<Education> findAll();
	public List<Education> findByIdPerson(int idPerson);
	public Education update(Education education) throws EducationNotFound;
	public Education findById(int id);

}
