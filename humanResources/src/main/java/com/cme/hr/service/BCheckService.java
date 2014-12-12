package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.BCheckNotFound;
import com.cme.hr.model.BCheck;

public interface BCheckService {
	
	public BCheck create(BCheck bCheck);
	public BCheck delete(int id) throws BCheckNotFound;
	public List<BCheck> findAll();
	public List<BCheck> findByIdPerson(int idPerson);
	public BCheck update(BCheck bCheck) throws BCheckNotFound;
	public BCheck findById(int id);

}
