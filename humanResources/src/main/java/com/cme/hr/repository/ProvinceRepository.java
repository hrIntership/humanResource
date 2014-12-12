package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

	List<Province> findByIdCountry(Integer idCountry);

}