package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.BCheck;

public interface BCheckRepository extends JpaRepository<BCheck, Integer> {

	List<BCheck> findByIdPerson(Integer idPerson);

}