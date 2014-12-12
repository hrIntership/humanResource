package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.SupplementaryInfoNotFound;
import com.cme.hr.model.SupplementaryInfo;
import com.cme.hr.repository.SupplementaryInfoRepository;

@Service
public class SupplementaryInfoServiceImpl implements SupplementaryInfoService {

	@Resource
	private SupplementaryInfoRepository supplementaryInfoRepository;

	@Override
	@Transactional
	public SupplementaryInfo create(SupplementaryInfo supplementaryInfo) {
		SupplementaryInfo createdSupplementaryInfo = supplementaryInfo;
		return supplementaryInfoRepository.save(createdSupplementaryInfo);
	}

	@Override
	@Transactional
	public SupplementaryInfo findById(int id) {
		return supplementaryInfoRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<SupplementaryInfo> findByIdPerson(int idPerson) {
		return supplementaryInfoRepository.findByIdPerson(idPerson);
	}

	@Override
	@Transactional(rollbackFor = SupplementaryInfoNotFound.class)
	public SupplementaryInfo delete(int id) throws SupplementaryInfoNotFound {
		SupplementaryInfo deletedSupplementaryInfo = supplementaryInfoRepository.findOne(id);

		if (deletedSupplementaryInfo == null)
			throw new SupplementaryInfoNotFound();

		supplementaryInfoRepository.delete(deletedSupplementaryInfo);
		return deletedSupplementaryInfo;
	}

	@Override
	@Transactional
	public List<SupplementaryInfo> findAll() {
		return supplementaryInfoRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = SupplementaryInfoNotFound.class)
	public SupplementaryInfo update(SupplementaryInfo supplementaryInfo) throws SupplementaryInfoNotFound {
		SupplementaryInfo updatedSupplementaryInfo = supplementaryInfoRepository.findOne(supplementaryInfo
				.getIdSI());

		if (updatedSupplementaryInfo == null)
			throw new SupplementaryInfoNotFound();

		updatedSupplementaryInfo.setOperation(supplementaryInfo.getOperation());
		updatedSupplementaryInfo.setOpAmount(supplementaryInfo.getOpAmount());
		updatedSupplementaryInfo.setOpCauses(supplementaryInfo.getOpCauses());
		updatedSupplementaryInfo.setAllergy(supplementaryInfo.getAllergy());
		updatedSupplementaryInfo.setPreexDiseases(supplementaryInfo.getPreexDiseases());
		updatedSupplementaryInfo.setBloodType(supplementaryInfo.getBloodType());
		
		return updatedSupplementaryInfo;
	}



}