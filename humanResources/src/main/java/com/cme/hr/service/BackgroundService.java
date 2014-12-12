package com.cme.hr.service;

import java.util.List;

import com.cme.hr.exception.BackgroundNotFound;
import com.cme.hr.model.Background;

public interface BackgroundService {
	
	public Background create(Background background);
	public Background delete(int id) throws BackgroundNotFound;
	public List<Background> findAll();
	public List<Background> findByIdPerson(int idPerson);
	public Background update(Background background) throws BackgroundNotFound;
	public Background findById(int id);

}
