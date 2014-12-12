package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.SupplementaryInfoNotFound;
import com.cme.hr.model.SupplementaryInfo;

public interface SupplementaryInfoService {
	
	public SupplementaryInfo create(SupplementaryInfo supplementaryInfo);
	public SupplementaryInfo delete(int id) throws SupplementaryInfoNotFound;
	public List<SupplementaryInfo> findAll();
	public List<SupplementaryInfo> findByIdPerson(int idPerson);
	public SupplementaryInfo update(SupplementaryInfo supplementaryInfo) throws SupplementaryInfoNotFound;
	public SupplementaryInfo findById(int id);

}
