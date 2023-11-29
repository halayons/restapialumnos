package com.alumnosrestapisql.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alumnosrestapisql.app.entity.Alumnos;


@Repository
public interface IAlumnosRepo extends JpaRepository<Alumnos, Long>{
	

}
