package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.FamilyMemberNotFound;
import com.cme.hr.model.FamilyMember;

public interface FamilyMemberService {
	
	public FamilyMember create(FamilyMember familyMember);
	public FamilyMember delete(int id) throws FamilyMemberNotFound;
	public List<FamilyMember> findAll();
	public List<FamilyMember> findByIdPerson(int idPerson);
	public FamilyMember update(FamilyMember familyMember) throws FamilyMemberNotFound;
	public FamilyMember findById(int id);

}
