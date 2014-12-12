package com.cme.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

	List<Staff> findByIdPerson(Integer idPerson);

}