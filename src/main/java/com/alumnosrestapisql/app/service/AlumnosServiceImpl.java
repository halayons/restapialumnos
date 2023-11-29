package com.alumnosrestapisql.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alumnosrestapisql.app.entity.Alumnos;
import com.alumnosrestapisql.app.repository.IAlumnosRepo;

@Service
public class AlumnosServiceImpl implements IAlumnosService{
	
	@Autowired
	private IAlumnosRepo alumnosRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumnos> findAll() {
		return alumnosRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Alumnos> findAll(Pageable pageable) {
		return alumnosRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Alumnos> findById(Long id) {
		return alumnosRepository.findById(id);
	}

	@Override
	@Transactional
	public Alumnos save(Alumnos alumnos) {
		return alumnosRepository.save(alumnos);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		alumnosRepository.deleteById(id);
	}
	
	
	

}
