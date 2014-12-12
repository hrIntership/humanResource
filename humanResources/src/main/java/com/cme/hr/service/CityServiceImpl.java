package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.model.City;
import com.cme.hr.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	
	@Resource
	private CityRepository cityRepository;
	
	@Override
	@Transactional
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public List<City> findByIdProvince(int idProvince) {
		return cityRepository.findByIdProvince(idProvince);
	}

}