package com.cme.hr.service;

import java.util.List;

import com.cme.hr.model.Province;

public interface ProvinceService {
	
	public List<Province> findAll();
	public List<Province> findByIdCountry(int idCountry);


}