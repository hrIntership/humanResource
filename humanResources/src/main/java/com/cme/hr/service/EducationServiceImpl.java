package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.EducationNotFound;
import com.cme.hr.model.Education;
import com.cme.hr.repository.EducationRepository;

@Service
public class EducationServiceImpl implements EducationService {

	@Resource
	private EducationRepository educationRepository;

	@Override
	@Transactional
	public Education create(Education education) {
		Education createdEducation = education;
		return educationRepository.save(createdEducation);
	}

	@Override
	@Transactional
	public Education findById(int id) {
		return educationRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<Education> findByIdPerson(int idPerson) {
		return educationRepository.findByIdPerson(idPerson);
	}

	@Override
	@Transactional(rollbackFor = EducationNotFound.class)
	public Education delete(int id) throws EducationNotFound {
		Education deletedEducation = educationRepository.findOne(id);

		if (deletedEducation == null)
			throw new EducationNotFound();

		educationRepository.delete(deletedEducation);
		return deletedEducation;
	}

	@Override
	@Transactional
	public List<Education> findAll() {
		return educationRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = EducationNotFound.class)
	public Education update(Education education) throws EducationNotFound {
		Education updatedEducation = educationRepository.findOne(education
				.getIdEducation());

		if (updatedEducation == null)
			throw new EducationNotFound();

		updatedEducation.setLevel(education.getLevel());
		updatedEducation.setInstitute(education.getInstitute());
		updatedEducation.setMajor(education.getMajor());
		updatedEducation.setYear(education.getYear());
		updatedEducation.setScore(education.getScore());
		updatedEducation.setStartDate(education.getStartDate());
		updatedEducation.setEndDate(education.getEndDate());
		
		return updatedEducation;
	}



}
