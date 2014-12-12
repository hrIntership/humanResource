package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {

	List<Education> findByIdPerson(Integer idPerson);

}