package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByIdProvince(Integer idProvince);

}