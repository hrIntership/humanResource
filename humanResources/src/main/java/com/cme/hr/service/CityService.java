package com.cme.hr.service;

import java.util.List;

import com.cme.hr.model.City;

public interface CityService {
	
	public List<City> findAll();
	public List<City> findByIdProvince(int idProvince);
	
}