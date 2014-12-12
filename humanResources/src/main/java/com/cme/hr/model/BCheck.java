package com.cme.hr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bcheck")
public class BCheck {

	@Id
	@GeneratedValue
	private Integer idBCheck;
	
	private Integer idPerson;

	private Integer bcra;

	private Integer cca;

	private Integer addressv;

	private Integer criminalv;

	private Integer ssnt;

	private Integer cev;

	private Integer academicv;

	private Integer financialc;

	private Integer hipaaa;

	public Integer getIdBCheck() {
		return idBCheck;
	}

	public void setIdBCheck(Integer idBCheck) {
		this.idBCheck = idBCheck;
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Integer getBcra() {
		return bcra;
	}

	public void setBcra(Integer bcra) {
		this.bcra = bcra;
	}

	public Integer getCca() {
		return cca;
	}

	public void setCca(Integer cca) {
		this.cca = cca;
	}

	public Integer getAddressv() {
		return addressv;
	}

	public void setAddressv(Integer addressv) {
		this.addressv = addressv;
	}

	public Integer getCriminalv() {
		return criminalv;
	}

	public void setCriminalv(Integer criminalv) {
		this.criminalv = criminalv;
	}

	public Integer getSsnt() {
		return ssnt;
	}

	public void setSsnt(Integer ssnt) {
		this.ssnt = ssnt;
	}

	public Integer getCev() {
		return cev;
	}

	public void setCev(Integer cev) {
		this.cev = cev;
	}

	public Integer getAcademicv() {
		return academicv;
	}

	public void setAcademicv(Integer academicv) {
		this.academicv = academicv;
	}

	public Integer getFinancialc() {
		return financialc;
	}

	public void setFinancialc(Integer financialc) {
		this.financialc = financialc;
	}

	public Integer getHipaaa() {
		return hipaaa;
	}

	public void setHipaaa(Integer hipaaa) {
		this.hipaaa = hipaaa;
	}
	
	

}
