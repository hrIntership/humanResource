package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.BCheckNotFound;
import com.cme.hr.model.BCheck;
import com.cme.hr.repository.BCheckRepository;

@Service
public class BCheckServiceImpl implements BCheckService {

	@Resource
	private BCheckRepository bCheckRepository;

	@Override
	@Transactional
	public BCheck create(BCheck bCheck) {
		BCheck createdBCheck = bCheck;
		return bCheckRepository.save(createdBCheck);
	}

	@Override
	@Transactional
	public BCheck findById(int id) {
		return bCheckRepository.findOne(id);
	}

	@Override
	@Transactional
	public List<BCheck> findByIdPerson(int idPerson) {
		return bCheckRepository.findByIdPerson(idPerson);
	}

	@Override
	@Transactional(rollbackFor = BCheckNotFound.class)
	public BCheck delete(int id) throws BCheckNotFound {
		BCheck deletedBCheck = bCheckRepository.findOne(id);

		if (deletedBCheck == null)
			throw new BCheckNotFound();

		bCheckRepository.delete(deletedBCheck);
		return deletedBCheck;
	}

	@Override
	@Transactional
	public List<BCheck> findAll() {
		return bCheckRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = BCheckNotFound.class)
	public BCheck update(BCheck bCheck) throws BCheckNotFound {
		BCheck updatedBCheck = bCheckRepository.findOne(bCheck.getIdBCheck());

		if (updatedBCheck == null)
			throw new BCheckNotFound();

		updatedBCheck.setIdBCheck(bCheck.getIdBCheck());

		return updatedBCheck;
	}

}
