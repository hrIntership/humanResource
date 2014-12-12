package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Background;

public interface BackgroundRepository extends JpaRepository<Background, Integer> {

	List<Background> findByIdPerson(Integer idPerson);

}