package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.FamilyMemberNotFound;
import com.cme.hr.model.FamilyMember;
import com.cme.hr.repository.FamilyMemberRepository;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

	@Resource
	private FamilyMemberRepository familyMemberRepository;

	@Override
	@Transactional
	public FamilyMember create(FamilyMember familyMember) {
		FamilyMember createdFamilyMember = familyMember;
		return familyMemberRepository.save(createdFamilyMember);
	}

	@Override
	@Transactional
	public FamilyMember findById(int id) {
		return familyMemberRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<FamilyMember> findByIdPerson(int idPerson) {
		return familyMemberRepository.findByIdPerson(idPerson);
	}

	@Override
	@Transactional(rollbackFor = FamilyMemberNotFound.class)
	public FamilyMember delete(int id) throws FamilyMemberNotFound {
		FamilyMember deletedFamilyMember = familyMemberRepository.findOne(id);

		if (deletedFamilyMember == null)
			throw new FamilyMemberNotFound();

		familyMemberRepository.delete(deletedFamilyMember);
		return deletedFamilyMember;
	}

	@Override
	@Transactional
	public List<FamilyMember> findAll() {
		return familyMemberRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = FamilyMemberNotFound.class)
	public FamilyMember update(FamilyMember familyMember) throws FamilyMemberNotFound {
		FamilyMember updatedFamilyMember = familyMemberRepository.findOne(familyMember
				.getIdFM());

		if (updatedFamilyMember == null)
			throw new FamilyMemberNotFound();

		updatedFamilyMember.setFullName(familyMember.getFullName());
		updatedFamilyMember.setRelationship(familyMember.getRelationship());
		updatedFamilyMember.setNationality(familyMember.getNationality());
		updatedFamilyMember.setIdType(familyMember.getIdType());
		updatedFamilyMember.setIdNumber(familyMember.getIdNumber());
		updatedFamilyMember.setBirthdate(familyMember.getBirthdate());
		
		return updatedFamilyMember;
	}



}
