package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.SupplementaryInfo;

public interface SupplementaryInfoRepository extends JpaRepository<SupplementaryInfo, Integer> {

	List<SupplementaryInfo> findByIdPerson(Integer idPerson);

}