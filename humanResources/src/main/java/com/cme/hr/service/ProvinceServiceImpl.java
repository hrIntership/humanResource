package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.model.Province;
import com.cme.hr.repository.ProvinceRepository;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	@Resource
	private ProvinceRepository provinceRepository;
	
	@Override
	@Transactional
	public List<Province> findAll() {
		return provinceRepository.findAll();
	}

	public List<Province> findByIdCountry(int idCountry) {
		return provinceRepository.findByIdCountry(idCountry);
	}

}