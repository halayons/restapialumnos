package com.alumnosrestapisql.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.alumnosrestapisql.app.entity.Alumnos;

public interface IAlumnosService {
	
	public Iterable<Alumnos> findAll();
	
	public Page<Alumnos> findAll(Pageable pageable);
	
	public Optional<Alumnos> findById(Long id);
	
	public Alumnos save(Alumnos alumnos);
	
	public void deleteById(Long id);

}
