package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {

	List<FamilyMember> findByIdPerson(Integer idPerson);

}