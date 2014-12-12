package com.cme.hr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cme.hr.exception.BackgroundNotFound;
import com.cme.hr.model.Background;
import com.cme.hr.repository.BackgroundRepository;

@Service
public class BackgroundServiceImpl implements BackgroundService {

	@Resource
	private BackgroundRepository backgroundRepository;

	@Override
	@Transactional
	public Background create(Background background) {
		Background createdBackground = background;
		return backgroundRepository.save(createdBackground);
	}

	@Override
	@Transactional
	public Background findById(int id) {
		return backgroundRepository.findOne(id);
	}
	
	@Override
	@Transactional
	public List<Background> findByIdPerson(int idPerson) {
		return backgroundRepository.findByIdPerson(idPerson);
	}

	@Override
	@Transactional(rollbackFor = BackgroundNotFound.class)
	public Background delete(int id) throws BackgroundNotFound {
		Background deletedBackground = backgroundRepository.findOne(id);

		if (deletedBackground == null)
			throw new BackgroundNotFound();

		backgroundRepository.delete(deletedBackground);
		return deletedBackground;
	}

	@Override
	@Transactional
	public List<Background> findAll() {
		return backgroundRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor = BackgroundNotFound.class)
	public Background update(Background background) throws BackgroundNotFound {
		Background updatedBackground = backgroundRepository.findOne(background
				.getIdBackground());

		if (updatedBackground == null)
			throw new BackgroundNotFound();

		updatedBackground.setIdBackground(background.getIdBackground());
		
		return updatedBackground;
	}



}
