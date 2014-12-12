package com.cme.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cme.hr.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}