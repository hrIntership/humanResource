package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.model.Country;
import com.cme.hr.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Resource
	private CountryRepository countryRepository;
	
	@Override
	@Transactional
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

}